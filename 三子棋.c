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
		printf("�����\n");
	}
	if(ret == 'O')
	{
		printf("�����\n");
	}
	if(ret == 'Q')
	{
		printf("ƽ��\n");
	}
}
int main()
{
	int input = 0;
	srand((unsigned int) time (NULL) );
	do
	{
		menu();
		printf("��������Ĳ�����");
		scanf("%d",&input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("��Ϸ�˳�\n");
			break;
		default:
			break;
		}
	}while(input);
	return 0;
}

#if 0
//����ָ��    ָ������   ����ָ��   ����ָ������ 
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
�洢��ͬ�������͵ļ��ϣ��������ڴ�(������)
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
����������������´�����������
1��sizeof(arr)    ����������ֽڴ�С
2��&arr+1     ������������


������������������Ԫ�صĵ�ַ , ����Ԫ����ʲô���ͣ�
            int *p     char *
2��arr[i]===> *(arr+i);
3��arr+i : arr����ָ��--��ȡ����arr������  int  +1:4���ֽ�
4��int len = sizeof(arr)/sizeof(arr[0]);  ʹ�õ�ǰ���ǣ�
���������ﶨ��  ��Ҫ������ʹ�á�

������ڴ棺
�ֲ�������-��ջ-��1M/2M
1������ʲôʱ��ȷ����С��        ����
2������ʲôʲôʱ������ڴ棿 ���е�ʱ��
3���������������ڴ棿       ջ-��1M/2M
4���ڴ�ӵ͵�ַ��ߵ�ַ�����ġ�
*/

int main()
{
	int arr[] = {1,2,3,4,5,6,7,8,9,10};
	int i = 0;
	for(i = 0; i < sizeof(arr)/sizeof(arr[0]);i++)
	{
		printf("&arr[%d] = %d\n", i, &arr[i]);
	}


	//arr[10] = 99;  ����Խ��  ���ܽ���д����  ���Ļ��������ֵ
	//printf("%d\n",arr[10]);
	//int len1 = sizeof(arr)/sizeof(arr[0]);
	///Show(arr,len1);
	//
	/*int arr2[6] = {1,2,3,4,5,6};
	int len2 = sizeof(arr2)/sizeof(arr2[0]);
	printf("%d,%d\n",len1,len2);*/

 


	
	
	

	//char crr[5] = {'a','b','c','d','e'};

	//char crr2[] = {'a','b','c','d','e','f'};

	//char crr3[5] = "abcd";//Ĭ����\0ռ��λ��

	//char crr4[6] = {'a','b','c','d','e'};

	//printf("%s\n",crr3);
	//��\0ֹͣ

	//int arr[10] = {1,2,3,4,5,6,7,8,9,0};//��������
	//int arr2[10] = {0};
	//int arr3[10] = {1,2,3,4};
	//int arr4[10];//Ĭ�������ֵ
	return 0;
}


//�ݹ�  
/*
1�������Լ�����
2����һ����������ֹ������
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