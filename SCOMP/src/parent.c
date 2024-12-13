#include "header.h"

/**
 * typedef struct data
 * {
 * //signals related
 *
 * struct sigaction sa;
 *
 * //pid of manager process
 *
 * int manager_pid;
 *
 * //config_file info
 * 
 * char *inp_dir;
 * char *out_dir;
 * int n_childs;
 * int sleep_time;
 *
 * //childs info
 *
 * int n_workers;	//num of current childs working
 * char *state;		//arr saving state of childs work
 * int *pids;		//arr saving pids of childs
 * } Data;
 */

Data s;

void end()
{
	raise(SIGINT);
}

void do_report()
{
	int len_create_dir = strlen(s.out_dir) + SLASH_SIZE + strlen(REPORT_DIR);
	char create_dir[len_create_dir + 1];

	snprintf(create_dir, sizeof(create_dir), "%s/%s", s.out_dir, REPORT_DIR);
	mkdir(create_dir, 0777);

	time_t t = time(NULL);
	struct tm tm = *localtime(&t);
	
	char timestamp[REPORT_TIMESTAMP_LEN + 1];

	snprintf(timestamp, sizeof(timestamp), "%d%02d%02d%02d%02d%02d", tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec);

	int len_filename = strlen(REPORT_FILENAME) + strlen(timestamp) + strlen(REPORT_EXTENSION);
	char filename[len_filename + 1];

	snprintf(filename, sizeof(filename), "%s%s%s", REPORT_FILENAME, timestamp, REPORT_EXTENSION);

	int len_output = strlen(s.out_dir) + SLASH_SIZE + strlen(REPORT_DIR) + SLASH_SIZE + strlen(filename);
	char output[len_output + 1];
	
	snprintf(output, sizeof(output), "%s/%s/%s", s.out_dir, REPORT_DIR, filename);

	int len_command = COMMANDS_LEN + strlen(s.out_dir) + strlen(REPORT_FILENAME) + strlen(output);
	char command[len_command + 1];

	snprintf(command, sizeof(command), "ls -R %s | grep -v \"%s\" > %s", s.out_dir, REPORT_FILENAME, output);

	system(command);
}

int **int_malloc_matrix(int row, int col)
{
	int **arr = (int **) malloc(sizeof(int *) * row);

	if (arr == NULL)
		end();

	for (int i = 0; i < row; i++)
	{
		arr[i] = (int *) malloc(sizeof(int) * col);

		if (arr[i] == NULL)
			end();
	}
	return arr;
}

void int_free_matrix(int **arr, int row)
{
	for (int i = 0; i < row; i++)
		free(arr[i]);
	free(arr);
}

void set_up_childs()
{
	int **down = int_malloc_matrix(s.n_childs, 2);
	char str_i[10];
	char str_fd[10];
	pid_t pid;
	
	s.state = (char *) malloc(sizeof(char) * s.n_childs);

	if (s.state == NULL)
		end();
	memset(s.state, 0, sizeof(char) * s.n_childs);

	s.pids = (int *) malloc(sizeof(int) * s.n_childs);

	if (s.pids == NULL)
		end();
	memset(s.pids, 0, sizeof(int) * s.n_childs);
	
	if (pipe(s.up))
		end();

	for (int i = 0; i < s.n_childs; i++)
	{
		if (pipe(down[i]))
			end();

		pid = fork();

		if (pid == 0)
		{
			//dup2(s.up[1], 2);	// childs writes to fd 2 to send info to pipe up

			close(s.up[0]);		// child doesnt need read side on up pipe

			dup2(down[i][0], 0);	// child reads from fd 0 to get info from pipe down

			close(down[i][1]);	// child doesnt need write side on down pipe

			snprintf(str_i, sizeof(str_i), "%d", i);

			snprintf(str_fd, sizeof(str_fd), "%d", s.up[1]);

			execl(WORKERS_FILE, WORKERS_FILE, str_i, s.inp_dir, s.out_dir, str_fd, NULL);
			kill(getppid(), SIGINT);
		}
		close(down[i][0]);		// parent doesnt need read side on down pipe

		s.pids[i] = pid;
	}
	close(s.up[1]);				// parent doesnt need write side on up pipe

	s.down = down;
	s.childs_created = 1;
}

char **malloc_matrix(int row, int col)
{
	char **arr = (char **) malloc(sizeof(char *) * row);

	if (arr == NULL)
		end();

	for (int i = 0; i < row; i++)
	{
		arr[i] = (char *) malloc(sizeof(char) * col);

		if (arr[i] == NULL)
			end();
	}
	return arr;
}

void free_matrix(char **arr, int row)
{
	for (int i = 0; i < row; i++)
		free(arr[i]);
	free(arr);
}

int check_candidate_num(int  num, char *str)
{
	char *token = strtok(str, "-");

	if (atoi(token) == num)
		return 1;
	return 0; 
}

int get_filenames_from_dir(char **names, char *directory)
{
	struct dirent *d;

	DIR *dir = opendir(directory);
	
	if (dir == NULL)
		end();

	int i = 0;

//	printf("Start reading dir on parent\n");
	while ((d = readdir(dir)) != NULL)
		strcpy(names[i++], d->d_name);
//	printf("Ended reading dir on parent\n");
	return i;
}

void dispatch_work()
{
	//dont do this if childs are all busy
	//process input dir
	//divide candiates
	//send them to free childs
	//end

	static int num_of_candidate = 1;

	if (s.n_workers < s.n_childs)
	{
		char **names = malloc_matrix(MAX_FILES, MAX_FILE_LENGTH);

		char str_candidate[MAX_INT_LEN + 1];

		int n_files = get_filenames_from_dir(names, s.inp_dir);

		int i = 0;

		while (s.n_workers < s.n_childs)
		{
		//	printf("N_WORKERS: %d\n", s.n_workers);
		//	printf("Some childs are free, cand:%d\n", num_of_candidate);
			if (s.n_workers < s.n_childs && i < n_files && check_candidate_num(num_of_candidate, names[i++]))
			{
		//		printf("There is at least one file of the next candidate\n");
				for (int j = 0; j < s.n_childs; j++)
				{
					if (s.state[j] == 0)
					{
		//				printf("This child is getting work: %d, cand: %d\n", j, num_of_candidate);
						snprintf(str_candidate, sizeof(str_candidate), "%d", num_of_candidate);
						write(s.down[j][1], str_candidate, 4);
						s.state[j] = 1;
						s.n_workers++;
						break;
					}
				}
				num_of_candidate++;
				i = 0;
			}
			if (i == n_files)
				break;
		}	
		free_matrix(names, MAX_FILES);
	}
}

void set_up_manager()
{
	pid_t pid;
	char str_sleep_time[10];

	snprintf(str_sleep_time, sizeof(str_sleep_time), "%d", s.sleep_time);

	pid = fork();

	if (pid == 0)
	{
		execl(MANAGER_FILE, MANAGER_FILE, s.inp_dir, str_sleep_time, NULL);
		kill(getppid(), SIGINT);
	}
	s.manager_pid = pid;
}

int get_file_size(FILE *fd)
{
	int size = 0;
	int cursor;

	cursor = ftell(fd);
	fseek(fd, 0, SEEK_END);
	size = ftell(fd);
	fseek(fd, 0, cursor);

	return size;
}

void parse_data(char *str)
{
	char d[] = "=\n";

	strtok(str, d);
	s.inp_dir = strdup(strtok(NULL, d));

	strtok(NULL, d);
	s.out_dir = strdup(strtok(NULL, d));

	strtok(NULL, d);
	s.n_childs = atoi(strtok(NULL, d));

	strtok(NULL, d);
	s.sleep_time  = atoi(strtok(NULL, d));
}

void process_config_file()
{
	FILE *fd = fopen(CONFIG_FILE, "r");

	int size = get_file_size(fd);

	if (size > CONFIG_FILE_MAX_SIZE)
		end();

	char *str = (char *) malloc(sizeof(char) * size + 1);

	if (str == NULL)
		end();

	if (fread(str, sizeof(char), size + 1, fd) <= 0)
		end();

	fclose(fd);
	
	parse_data(str);

	free(str);
}

void handler_sigint(int sig)
{
//	write(1, "INT\n", 4);
	(void) sig;

	if (s.manager_pid != -2)
	{
		kill(s.manager_pid, SIGKILL);
		wait(NULL);
	}

	
	if (s.childs_created)
	{
		for (int i = 0; i < s.n_childs; i++)
			kill(s.pids[i], SIGKILL);

		for (int i = 0; i < s.n_childs; i++)
			wait(NULL);
	}

	exit(1);
}

void handler_sigusr1(int sig)
{
	(void) sig;
//	write(1, "SIG1\n", 5);

	dispatch_work();
}

void set_up_signals()
{
/*	sigset_t set;

	sigfillset(&set);
	sigdelset(&set, SIGUSR1);
	sigdelset(&set, SIGINT);
	sigprocmask(SIG_BLOCK, &set, NULL);
*/
	struct sigaction sa;

	memset(&sa, 0, sizeof(sa));
	sigfillset(&sa.sa_mask);
	sigdelset(&sa.sa_mask, SIGINT);
	sa.sa_handler = handler_sigusr1;
	sigaction(SIGUSR1, &sa, NULL);
	sa.sa_handler = handler_sigint;
	sigaction(SIGINT, &sa, NULL);
}

void set_up_structure()
{				// 0 kills all processess in group id
	s.manager_pid = -2;	// and -1 kills all processes apart from this one
	s.n_workers = 0;
	s.childs_created = 0;
}

int get_n_workers()
{
	int j = 0;

	for (int i = 0; i < s.n_childs; i++)
	{
//		printf("%d ", s.state[i]);
		if (s.state[i])
			j++;
	}
//	printf("\n");
	return j;
}

void repeat()
{
	int i = -1;
	int nb;
	int index;
	char buf[10];

	while (++i < MAX_ITER)
	{
		if ((nb = read(s.up[0], &buf, 4)) != -1)
		{

			buf[nb] = '\0';

			index = atoi(buf);

			if (index >= 0 && index <= s.n_childs)
			{
				s.state[index] = 0;

			//	printf("childs free, buf: %s\n", buf);

				//if (s.n_workers != 0)	// hardcoded
				//	s.n_workers--;
				s.n_workers = get_n_workers();

				do_report();
			}
		}
	}
}

void terminate()
{
	// never going to be executed, but good practice
	end();
}

void start()
{
	set_up_structure();

	set_up_signals();

	set_up_manager();

	set_up_childs();

	repeat();

	terminate();
}

//arguments are optional
//but if there are any:
//argv[1] inp_dir
//argv[2] out_dir
//argv[3] n_childs
//argv[4] sleep_time

int main(int argc, char **argv)
{
	if (argc == 1)
		process_config_file();
	else if (argc == 5)
	{
		s.inp_dir = argv[1];
		s.out_dir = argv[2];
		s.n_childs = atoi(argv[3]);
		s.sleep_time = atoi(argv[4]);
	}
	else
		end();
//	printf("PID: %d\n", getpid());
	start();
}
