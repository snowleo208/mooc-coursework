#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main (void)
{
	//get string from user input
	string n = get_string();
	for (int i = 0, j = strlen(n); i < j; i++)
	{
		//skip this loop if n & n+1 are spaces
		if(n[i] == ' ' && n[i+1] == ' ')
		{
			continue;
		}
		else if ((i == 0 && n[i] != ' ') ||( i > 0 && n[i-1] == ' ' && n[i] != ' '))
		{
			printf("%c", toupper(n[i]));
		}
	}
	printf("\n"); //add end break at the end after loop
}
