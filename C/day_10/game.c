#define _CRT_SECURE_NO_WARNINGS 1
#include "game.h"

void menu()
{
	printf("*****************\n");
	printf("*****0.exit*******\n");
	printf("*****1.play******\n");
	printf("*****************\n");
}
void game()
{

	int ret = 0;

	char board[3][3] = {0};

	InitBoard(board,3,3);

	ShowBoard(board,3,3);

	while(1)
	{
		PlayerMove(board,3,3);
		ret = IsWin(board,3,3);
		if(ret != ' ')
		{
			break;
		}
		ShowBoard(board,3,3);
		ComputerMove(board,3,3);
		ret = IsWin(board,3,3);
		if(ret != ' ')
		{
			break;
		}
		ShowBoard(board,3,3);
	}

	if(ret == 'X')
	{
		printf("你真棒\n");
	}
	if(ret == 'O')
	{
		printf("你真菜\n");
	}
	if(ret == 'Q')
	{
		printf("平局\n");
	}
}
int main()
{
	int input = 0;
	srand((unsigned int) time (NULL) );
	do
	{
		menu();
		printf("请输入你的操作：");
		scanf("%d",&input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("游戏退出\n");
			break;
		default:
			break;
		}
	}while(input);
	return 0;
}

#if 0
//数组指针    指针数组   函数指针   函数指针数组 
void Show(int arr[][4],int row,int col)
{
	int i = 0;
	for(i = 0;i < row;i++)
	{
		int j = 0;
		for(j = 0;j < col;j++)
		{
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
}

int main()
{
	int arr[3][4] = {1,2,3,4,5,6,7,8,9,10,11,12};
	printf("%d,%d\n",&arr[1][0],&arr[0][4]);

	//Show(arr,3,4);

	//int i = 0;
	//for(i = 0;i < 3;i++)
	//{
	//	int j = 0;
	//	for(j = 0;j < 4;j++)
	//	{
	//		arr[i][j] = i*4+j;
	//	}
	//}
	//printf("hhhh\n");
	
	

	//int arr[3][3] = {1,2,3,4,5,6,7,8,9};
	//int arr2[3][3] = {{1,2,3},{4,5,6},{7,8,9}};
	//int arr3[3][3] = {{1,2},{4,5,6},{8,9}};

	//int arr4[][3] = {{1,2},{4,5,6},{8,9}};

	//int arr4[3][] = {{1,2},{4,5,6},{8,9}};

	return 0;
}




/*
存储相同数据类型的集合，连续的内存(物理上)
*/

void Show1(int arr[],int len)
{
	
	int i = 0;
	for(i = 0;i < len;i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void Show(int *arr,int len)
{
	//int len = sizeof(arr)/sizeof(arr[0]);
	int i = 0;
	for(i = 0;i < len;i++)
	{
		//printf("%d ", arr[i]);
		printf("%d ", *(arr+i));
	}
	printf("\n");
}
/*
数组名在两种情况下代表整个数组
1、sizeof(arr)    整个数组的字节大小
2、&arr+1     。。。。。。


数组名：代表数组首元素的地址 , 看首元素是什么类型？
            int *p     char *
2、arr[i]===> *(arr+i);
3、arr+i : arr代表指针--》取决于arr的类型  int  +1:4个字节
4、int len = sizeof(arr)/sizeof(arr[0]);  使用的前提是：
数组在哪里定义  需要在哪里使用。

数组的内存：
局部的数组-》栈-》1M/2M
1、数组什么时候确定大小？        编译
2、数组什么什么时候分配内存？ 运行的时候
3、数组最大分配多大内存？       栈-》1M/2M
4、内存从低地址向高地址增长的。
*/

int main()
{
	int arr[] = {1,2,3,4,5,6,7,8,9,10};
	int i = 0;
	for(i = 0; i < sizeof(arr)/sizeof(arr[0]);i++)
	{
		printf("&arr[%d] = %d\n", i, &arr[i]);
	}


	//arr[10] = 99;  数组越界  不能进行写操作  读的话都是随机值
	//printf("%d\n",arr[10]);
	//int len1 = sizeof(arr)/sizeof(arr[0]);
	///Show(arr,len1);
	//
	/*int arr2[6] = {1,2,3,4,5,6};
	int len2 = sizeof(arr2)/sizeof(arr2[0]);
	printf("%d,%d\n",len1,len2);*/

 


	
	
	

	//char crr[5] = {'a','b','c','d','e'};

	//char crr2[] = {'a','b','c','d','e','f'};

	//char crr3[5] = "abcd";//默认有\0占据位置

	//char crr4[6] = {'a','b','c','d','e'};

	//printf("%s\n",crr3);
	//以\0停止

	//int arr[10] = {1,2,3,4,5,6,7,8,9,0};//定义数组
	//int arr2[10] = {0};
	//int arr3[10] = {1,2,3,4};
	//int arr4[10];//默认是随机值
	return 0;
}


//递归  
/*
1、调用自己本身
2、有一个趋近于终止的条件
 h  e  l  l  o  \0
 1   1   2   3   5   8   13  21 ......

 n   

 f(n) = f(n-1)+f(n-2);

*/
int MyStrlen(char *str)
{
	if(*str == '\0')
	{
		return 0;
	}
	else
	{
		return 1+MyStrlen(str+1);
	}
}
/*
 1   1   2   3   5   8   13  21 ......
 n   
 f(n) = f(n-1)+f(n-2);
*/
int count = 0;
int Fabonaci(int n)
{
	if(n == 1 || n==2)
	{
		count++;
		return 1;
	}
	return Fabonaci(n-1) + Fabonaci(n-2);
}
int Fabonaci2(int n)
{
	int f1 = 1;
	int f2 = 1;
	int f3 = 0;
	int i = 0;
	for(i = 3;i <= n;i++)
	{
		f3 = f1+f2;//2  3    5
		f1 = f2;//1    2
		f2 = f3;//2    3
	}
	return f3;
}
//1   A-> C
//2   A-> B  A->C  B->C
//3   A->C  A-> B  C->B  A->C  B->A  B-> C  A-> C
//64   2^64-1
void Move(char pos1,char pos2)
{
	printf("%c->%c ",pos1,pos2);
}

void Hanio(int n,char pos1,char pos2,char pos3)
{
	if(n == 1)
	{
		Move(pos1,pos3);
	}
	else
	{
		Hanio(n-1,pos1,pos3,pos2);
		Move(pos1,pos3);
		Hanio(n-1,pos2, pos1,pos3);
	}
}

int main()
{
	//Hanio(1,'A','B','C');
	//printf("\n");
	//Hanio(3,'A','B','C');
	//printf("\n");
	Hanio(64,'A','B','C');
	printf("\n");
	//printf("%d\n",Fabonaci2(50));
	//printf("count = %d\n",count);
	//char *str = "hello";//"hello";\0
	//int len= MyStrlen(str);//\0      0     '0' -> 48
	//printf("%d\n",len);
	return 0;
}
#endif