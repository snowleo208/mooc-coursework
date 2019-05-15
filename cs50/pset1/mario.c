#include <stdio.h>
#include <cs50.h>

int pyramid (int n);

int main (void)
{
	int n = get_int("Height: ");
	while (n > 23 || n < 0) {
		n = get_int("Height: ");
	}
	
	for (int i = 0; i < n; i++) {
		for (int p = 0; p <= n; p++) {
			if(p < n - i-1) {
				printf(" ");
			} else if(p == n) {
				printf("#\n");
			} else {
				printf("#");
			}
		}
	}
}
