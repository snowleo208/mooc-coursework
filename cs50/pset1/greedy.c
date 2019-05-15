#include <stdio.h>
#include <cs50.h>
#include <math.h>

float cal (float x);

int main (void)
{
	printf("O hai! How much change is owed?");
	float n = get_float();
	while (n < 0) {
		n = get_float("How much change is owed?");
	}
	printf("%d \n", (int) cal(n));
}

float cal (float x)
{
	int coin[] = {25, 10, 5, 1};
	x = (int) round(x * 100);
	int y = 0;
	for (int i = 0; i < 4; i++) {
		y += (int) x / coin[i];
		x = (int) x % coin[i];
	}
	return (int) y;
}
