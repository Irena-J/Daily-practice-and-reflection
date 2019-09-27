#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>

void Sum(int num,int n)
{
	int sum=0;
	int temp = 0;
	for (int i = 1; i < n; i++)
	{
		temp= num * 10 + num;
		sum += temp;
		printf("%d", sum);
		
	}
}

int main()
{
	int num;
	int n;
	int sum = 0;
	scanf("%d%d", &num, &n);
	Sum(num, n);
	system("pause");
	return 0;
}