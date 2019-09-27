#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
int main()
{
	int n = 0x11223344;
	char*pc = (char*)&n;
	int *pi = &n;
	printf("%x\n",*pi);
	printf("%x",*pc);
	system("pause");
	return 0;
}