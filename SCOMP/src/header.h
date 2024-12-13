#ifndef HEADER_H
#define HEADER_H

#include <time.h>
#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <dirent.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <sys/types.h>

#define CONFIG_FILE "./config.txt"
#define MANAGER_FILE "./looker"
#define WORKERS_FILE "./childs"

#define REPORT_DIR "reports"
#define REPORT_FILENAME "report"
#define REPORT_TIMESTAMP_LEN 14
#define REPORT_EXTENSION ".txt"
//replace REPORT_FILENAME and REPORT_EXTENSION by REPORT_FORMAT "report%s.txt"
#define COMMANDS_LEN 22
#define SLASH_SIZE 1
#define MKDIR_LEN 6
#define MV_LEN 4

#define CONFIG_FILE_MAX_SIZE 10000
#define CONFIG_FILE_MAX_LINES 4

#define MAX_FILES 1000
#define MAX_FILE_LENGTH 100
#define MAX_INT_LEN 10

#define CF_INP_DIR_KEY "INPUT_DIR"
#define CF_OUT_DIR_KEY "OUTPUT_DIR"
#define CF_N_CHILD_KEY "NUM_OF_CHILDS"
#define CF_SLEEP_TIME_KEY "SLEEP_TIME"

#define DEFAULT_FILENAME "-candidate-data.txt"
#define DEFAULT_FILENAME_LENGTH 19
#define JOB_REFERENCE_MAX_LENGTH 20
#define CANDIDATE_FOLDER_NAME "candidate_"
#define CANDIDATE_NUM_MAX_LEN 10

#define MAX_ITER 1000000

typedef struct data
{
	//pid of manager process

	int manager_pid;

	//childs created flag
	int childs_created;

	//pipes
	int **down;	//[0] child reads  | [1] parent writes
	int up[2];	//[0] parent reads | [1] childs writes

	//config_file info
	
	char *inp_dir;
	char *out_dir;
	int n_childs;
	int sleep_time;

	//childs info

	int n_workers;	//num of current childs working
	char *state;	//arr saving state of childs work
	int *pids;	//arr saving pids of childs
} Data;

void end();
void do_report();
void set_up_childs();
void set_up_signals();
void set_up_manager();
void process_config_file();
void handler_sigint(int sig);
void handler_sigusr1(int sig);

int get_file_size(FILE *fd);

#endif
