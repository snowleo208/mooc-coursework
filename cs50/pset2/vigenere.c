#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int checkAlpha (string text);

int main (int argc, string argv[])
{
	if(argc != 2 || !checkAlpha(argv[1])) {
		return 1;
	}
	
   int key = 0; //for each alphabet in argv[1]
   int time = 0; // for looping alphabet in argv[1]
   
	//get string from user input
	string n = get_string("plaintext:");
	printf("ciphertext:");
	for (int i = 0, j = strlen(n); i < j; i++)
	{
			if(time >= strlen(argv[1])) {
				time = 0;
			}
			key = argv[1][time];
			
			if (isupper(key)) {
				// check if key is lower or uppercase
				key = (key - 65) % 26;
			} else if(islower(key)) {
				key =  (key - 97) % 26;
			}
			
			if((int) n[i] >= 'A' && (int) n[i] <= 'Z')
			{
				// check if n[i] is uppercase,
				// if yes, add timer
				printf("%c", ((n[i] - 65) + key) % 26 + 65);
				time++;
			} 
			else if((int) n[i] >= 'a' && (int) n[i] <= 'z')
			{
				// check if n[i] is lowercase
				// if yes, add timer
				printf("%c", ((n[i] - 97) + key) % 26 + 97);
				time++;
			}
			else 
			{
				printf("%c", n[i]);
			}
	}
	printf("\n");
	return 0;
}

int checkAlpha (string text)
{
	// for validate if string is alphabet characters
	for (int i = 0, j = strlen(text); i < j; i++)
	{
		if(isalpha(text[i]))
		{
			continue;
		}
		else
		{
			return false;
		}
	}
}
