#include <stdio.h>
#include <cs50.h>

int main (void)
{
	printf("Minutes: ");
	int i = get_int();
	printf("Bottles: %d \n", (int)((i * 1.5 * 128) / 16));
}
