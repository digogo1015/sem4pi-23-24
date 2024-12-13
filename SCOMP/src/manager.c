#include "header.h"

//argc = 4
//argv[0] = ./manager
//argv[1] = "input_dir"
//argv[2] = sleep_time

//read dir(passed in argv[1])
//check files in dir
//if files in dir signal parent
//kill with pid_parent from getppid()
//wait the number of seconds in sleep_time from argv[2]
//repeat

int check_dir(char *name)
{
	int i = 0;
	struct dirent *d;
	DIR *dir = opendir(name);

	if (dir == NULL)
		return 1;
	while ((d = readdir(dir)) != NULL)
		if (++i > 2)
			break;
	closedir(dir);
	if (i <= 2)
		return 0;
	return 1;
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
	if (argc != 3)
	{
		perror("Invalid number of Arguments");
		kill(getppid(), SIGINT);
	}
	
	set_up_signals();

//	printf("MANAGER\n");

	int i = -1;
	int sleep_time = atoi(argv[2]);

	while (++i < MAX_ITER)
	{
		if (check_dir(argv[1]))
			kill(getppid(), SIGUSR1);
		sleep(sleep_time);
	}
}

