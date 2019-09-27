#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

void Get_Num(int num)
{
	int i = 0;
	for (i = 30; i >= 0; i -= 2)
	{
		printf("%d", (num >> i) & 1);
	}
	printf("\n");
	for (i = 31; i >= 1; i -= 2)
	{
		printf("%d", (num >> i) & 1);
	}
}

int main()
{
	Get_Num(4);
	system("pause");
	return 0;
}