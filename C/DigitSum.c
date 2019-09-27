#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

int DigitSum(int n)
{
	
	if (n < 10)
	{
		return n;
	}
	else
	{
		return  DigitSum(n / 10)+n % 10 ;
	}
	
	
}
int main()
{
	printf("%d",DigitSum(1729));
	system("pause");
	return 0;
}