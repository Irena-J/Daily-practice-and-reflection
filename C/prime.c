#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>
int main()
{
	int count = 0;
	for (int i = 100; i < 200; i++)
	{
		int x = 0;
		
		for (x = 2; x < i; i++)
		{
			if (i%x == 0)
			{
				break;
			}
		}
		 if (i == x)
		{
			printf("%d\n", i);
			count++;
		}
	}
	system("pause");
	return 0;
}