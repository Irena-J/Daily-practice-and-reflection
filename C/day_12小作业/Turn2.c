//#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//
//int length(char *arr)
//{
//	int i = 0;
//	while (arr[i] != '\0')
//	{
//		i++;
//	}
//	return i;
////}
//void change(char *a, char *p)
//{
//	char tem;
//	while (a < p)
//	{
//		tem = *a;
//		*a = *p;
//		*p = tem;
//		a++;
//		p--;
//	}
//
//}
//int main()
//{
//	char arr[] = "students a am i";
//	char *p = arr;
//	char *q = arr;
//	int flag = 0;
//	for (int i = 0; arr[i] != '\0'; i++)
//	{
//		if ((flag == 0) && (arr[i] != ' '))
//		{
//			p = arr + i;
//			flag = 1;
//		}
//		else if ((flag == 1) && (arr[i] == ' '))
//		{
//			q = arr + i - 1;
//			flag = 0;
//			change(p, q);
//		}
//	}
//	change(arr, arr + length(arr) - 1);
//	printf("%s", arr);
//	system("pause");
//	return 0;
//}