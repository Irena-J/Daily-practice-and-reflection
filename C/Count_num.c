#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

 int Count_One(unsigned int num)
{
	 int count = 0;
	 while (num)
	 {
		 count++;
		 num = num&(num - 1);
	 }
	 return count;
}

int main()
{
	int count = 0;
	printf("%d", Count_One(15));
	system("pause");
	return 0;
}