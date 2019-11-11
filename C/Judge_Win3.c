//#define _CRT_SECURE_NO_WARNINGS 1
//#include <stdio.h>
//#include<windows.h>
//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int d = 0;
//	int e = 0;
//	int n = 0;
//	int flag = 0;
//	for (a = 1; a <= 5; a++)
//	{
//		for (b = 1; b <= 5; b++)
//		{
//			for (c = 1; c <= 5; c++)
//			{
//				for (d = 1; d <= 5; d++)
//				{
//					for (e = 1; e <= 5; e++)
//					{
//						if (((b == 1) + (a == 3) == 1)
//							&& ((b == 2) + (e == 4) == 1)
//							&& ((c == 1) + (d == 2) == 1)
//							&& ((c == 5) + (d == 3) == 1)
//							&& ((e == 4) + (a == 1) == 1))
//						{
//							flag = 0;
//							n |= (1 << (a - 1));
//							n |= (1 << (b - 1));
//							n |= (1 << (c - 1));
//							n |= (1 << (d - 1));
//							n |= (1 << (e - 1));
//							while (n)
//							{
//								if (n % 2 == 0)
//								{
//									flag = 1;
//								}
//								n /= 2;
//							}
//							if (flag == 0)
//								printf("a = %d b = %d c = %d d = %d e = %d\n", a, b, c, d, e);
//						}
//
//					}
//
//				}
//			}
//		}
//	}
//	system("pause");
//	return 0;
//}
