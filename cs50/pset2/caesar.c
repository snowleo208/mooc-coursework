#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>  // for strtol

int main (int argc, string argv[])
{
	if(argc != 2) {
		return 1;
	}
	int key = strtol(argv[1], NULL, 10);
	//get string from user input
	string n = get_string("plaintext:");
	printf("ciphertext:");
	for (int i = 0, j = strlen(n); i < j; i++)
	{
		if((int) n[i] >= 'A' && (int) n[i] <= 'Z')
		{
			//check if it is uppercase or not, if yes,
			// get character of n + key
			// %26 means to get its position in A-Z,
			// if n >= Z, it will revert back to ABC...
			printf("%c", ((n[i] - 65) + key) % 26 + 65);
		} 
		else if((int) n[i] >= 'a' && (int) n[i] <= 'z')
		{
			// check if n[i] is lowercase
			printf("%c", ((n[i] - 97) + key) % 26 + 97);
		}
		else 
		{
			printf("%c", n[i]);
		}
		
	}
	printf("\n");
	return 0;
}
