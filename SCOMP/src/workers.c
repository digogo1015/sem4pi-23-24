#include "header.h"

//args
//argc = 5
//argv[1] = index of child in arr of parent
//argv[2] = input_directory
//argv[3] = output_directory
//argv[4] = up[1], fd to write to parent

void end()
{
	raise(SIGINT);
	exit(1);
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
	char *token = strtok(strdup(str), "-");

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

	while ((d = readdir(dir)) != NULL)
		strcpy(names[i++], d->d_name);
	return i;
}

int	intlen(int n)
{
	int	i;

	i = 1;
	if (n <= -1)
		n *= -1;
	while (n > 9)
	{
		n /= 10;
		i++;
	}
	return (i);
}

void process_default_file(char *dst, int size, char *out_dir, char *in_dir, char *file, int candidate)
{
	// reads first line of file
	// creates folder of job reference
	// creates subfolder of candidate_NUM

	// 1) mkdir ../output_dir/IBM001
	// 2) mkdir ../output_dir/IBM001/candidate_N
	// 3) return ../output_dir/IBM001/candidate_N
	
	// 1) mkdir + out_dir + job_reference_dir 			= mkdir job_reference_dir_path
	// 2) mkdir + out_dir + job_reference_dir + candidate + N 	= mkdir candidate_dir_path
	// 3) out_dir + job_reference_dir + candidate + N 		= (return) candidate_dir_path
	
	// job_reference_dir_path = out_dir + job_reference_dir
	// candidate_dir_path = job_reference_dir_path + candidate + N
	
	char file_to_read[strlen(in_dir) + SLASH_SIZE + strlen(file) + 1];

	snprintf(file_to_read, sizeof(file_to_read), "%s/%s", in_dir, file);
	
	FILE *fd = fopen(file_to_read, "r");

	char job_ref_dir[JOB_REFERENCE_MAX_LENGTH + 1];

	fgets(job_ref_dir, sizeof(job_ref_dir), fd);
	job_ref_dir[strlen(job_ref_dir) - 1] = '\0';

	char job_ref_dir_path[strlen(out_dir) + SLASH_SIZE + strlen(job_ref_dir) + 1];

	snprintf(job_ref_dir_path, sizeof(job_ref_dir_path), "%s/%s", out_dir, job_ref_dir);

	char candidate_dir_path[strlen(job_ref_dir_path) + SLASH_SIZE + strlen(CANDIDATE_FOLDER_NAME) + intlen(candidate) + 1];

	snprintf(candidate_dir_path, sizeof(candidate_dir_path), "%s/%s%d", job_ref_dir_path, CANDIDATE_FOLDER_NAME, candidate);

	char command1[MKDIR_LEN + strlen(job_ref_dir_path) + 1];

	snprintf(command1, sizeof(command1), "mkdir %s", job_ref_dir_path);

	char command2[MKDIR_LEN + strlen(candidate_dir_path) + 1];

	snprintf(command2, sizeof(command2), "mkdir %s", candidate_dir_path);

	snprintf(dst, size, "%s", candidate_dir_path);

//	struct stat status;
	
//	if (stat(job_ref_dir_path, &status) == 0 && !(S_ISDIR(status.st_mode)))
//	{
//		printf("-----mkdir %s\n", command1);
		system(command1);
//	}
//	if (stat(candidate_dir_path, &status) == 0 && !(S_ISDIR(status.st_mode)))
//	{
//		printf("-----mkdir %s\n", command2);
		system(command2);
//	}
}

void mv_file(char *dst, char *in_dir, char *file)
{
	char command[MV_LEN + strlen(in_dir) + SLASH_SIZE + strlen(file) + strlen(dst) + 1];

	snprintf(command, sizeof(command), "mv %s/%s %s", in_dir, file, dst);

	system(command);
}

int check_default_file(char *file)
{
	strtok(strdup(file), "-\0");
	char *token = strtok(NULL, "\0");
	char arr[strlen(token) + 1 + 1];

	snprintf(arr, sizeof(arr), "-%s", token);

	if (strcmp(arr, DEFAULT_FILENAME))
		return 0;
	return 1;

}

void process_candidate(char *in_dir, char *out_dir, int candidate)
{
	//read input files
	// loop through array of files (names), and find the one that is NUM-candidate-data.txt
	// after that, read the first line of that file, that is going to be the output_subfolder
	// like output_dir/JOB_REFERENCE/ 
	// 			^-- output_subfolder
	// loop again through array and move every file that starts with NUM to 
	// ../output_dir/JOB_REFERENCE/candidate_NUM/

	char **names = malloc_matrix(MAX_FILES, MAX_FILE_LENGTH);
	
	int n_files = get_filenames_from_dir(names, in_dir);

	char candidate_dir[strlen(out_dir) + SLASH_SIZE + JOB_REFERENCE_MAX_LENGTH + SLASH_SIZE + strlen(CANDIDATE_FOLDER_NAME) + CANDIDATE_NUM_MAX_LEN + 1];

	for (int i = 0; i < n_files; i++)
	{
		if (check_candidate_num(candidate, names[i]) && check_default_file(names[i]))
		{
			process_default_file(candidate_dir, sizeof(candidate_dir), out_dir, in_dir, names[i], candidate);
			break;
		}
	}

	for (int i = 0; i < n_files; i++)
	{
		if (check_candidate_num(candidate, names[i]))
			mv_file(candidate_dir, in_dir, names[i]);
	}

	free_matrix(names, MAX_FILES);
}

void sigint_handler(int sig)
{
	(void) sig;

	kill(getppid(), SIGINT);
}

void set_up_signals()
{
	struct sigaction sa;

	memset(&sa, 0, sizeof(sa));

	sa.sa_handler = sigint_handler;
	sigaction(SIGINT, &sa, NULL);
}

int main(int argc, char **argv)
{
	//wait for candidate number sent from parent
	//process files (move from one folder to another)
	//send msg through pipe to tell parent he is free
	//repeat

	if (argc != 5)
		kill(getppid(), SIGINT);

	set_up_signals();
	
//	printf("CHILD ALIVE: %s, pid: %d\n", argv[1], getpid());

	int i = -1;
	char buf[4];

	while (++i < MAX_ITER)
	{
		if (read(0, buf, 4) == -1)
			end();
		else 
		{
//			printf("got work %d, child: %s\n", atoi(buf), argv[1]);
			process_candidate(argv[2], argv[3], atoi(buf));
			write(atoi(argv[4]), argv[1], 4);
//			printf("Child %s: work done %d\n", argv[1], atoi(buf));
		}
	}
}
