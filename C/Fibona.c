#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

int Fib(int n)
{
	if (n <= 2)
	{
		return 1;
		
	}
	else
	{
		return Fib(n - 1) + Fib(n - 2);
		
	}
	printf("%d", n);
}
int main()
{
	printf("%d", Fib(4));
	system("pause");
	return 0;
}