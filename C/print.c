#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

void Print_Num(int n)
{
	if (n > 9)
	{
		 Print_Num(n / 10);
	}
	printf("%d", n % 10);
}

int main()
{

	 Print_Num(124);
	system("pause");
	return 0;
}