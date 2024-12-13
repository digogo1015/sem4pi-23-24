
all:
	@gcc -Wall -Wextra -Werror parent.c -o bot
	@gcc -Wall -Wextra -Werror manager.c -o looker
	@gcc -Wall -Wextra -Werror workers.c -o childs
	@./bot 2> /dev/null

clean:
	@rm bot looker childs
