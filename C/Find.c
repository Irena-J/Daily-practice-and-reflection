#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

int Find(int num1, int num2)
{
	int tmp = num1 ^ num2;
	int count = 0;
	while (tmp != 0)
	{
		count++;
		tmp = tmp & (tmp - 1);
	}
	return count;
}


int main()
{
	printf("%d\n", Find(1999, 2299));
	system("pause");
	return 0;
}