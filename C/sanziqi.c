 #define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<stdlib.h>
#define col 3
#define row 3

void play();

//打印游戏界面
void menu()
{
	int num=0;
	printf("=====enter game=====\n");
	printf("*****1.paly*****\n");
	printf("*****2.exit*****\n");
	printf("please input your choice");
	scanf("%d",&num);
	switch (num)
	{
	case 1:
		play();
		break;
	case 2:
		printf("exit");
		break;
	default:
		printf("plrase input 1 or 2");
	}
}


//初始化棋盘
void InitBoard(char board[][col])
{
	int i = 0;
	for (i = 0; i < row; i++)
	{
		int j = 0;
		for (j = 0; j < col; j++)
		{
			board[i][j] = ' ';
		}
	}
}




//打印棋盘的格式 
void show(char board[row][col])
{
	int i = 0;
	for (i = 0; i < col; i++)
	{
		int j = 0;
		for (j = 0; j < row; j++)
		{
			printf("_%c_", board[i][j]);
			printf("|"); 
		}
		printf("\n");
	}

}

//玩家移动
void playerMove(char board[][col])
{
	int x = 0;
	int y = 0;

	while (1)
	{
		printf("玩家移动");
		printf("please input ");
		scanf("%d%d", &x, &y);
		if (x >= 1 && y <= 3)
		{
			if (board[x - 1][y - 1] == ' ')
			{
				board[x - 1][y - 1] = 'X';
				break;
			}
			else
			{
				printf("此位置已经被下过了");
			}
		}
		else
		{
			printf("此坐标不合法");
		}
	}
}

void PcMove(char board[][col])
{
	srand((unsigned int)time(NULL));
	int x = 0;
	int y = 0;
	while (1)
	{
		x = rand() % row;
		y = rand() % col;
		if (board[x][y] == ' ')
		{
			board[x][y] = 'o';
			break;
		}
	}
}

int IsFull(char board[][col])
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		int j;
		for (j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')
			{
				return 0;
			}
		}
	}
	return 1;
}


//判断游戏是否结束
int IsWin(char board[][col])
{
	int i = 0;
	for (i = 0; i < row; i++)
	{
		if (board[i][0] == board[i][1] && board[i][2] == board[i][1] &&board[i][0] != ' ')
		{
			return board[i][0];
		}
		if (board[0][i] == board[1][i] && board[2][i] == board[1][i] && board[0][i] != ' ')
		{
			return board[0][i];
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[2][0] == board[0][2] && board[0][2] != ' ')
		{
			return board[0][2];
		}
		if (IsFull(board) == 1)
		{
			return 'p';//平局
		}
	}
	return ' ';//无赢家
}



//
void play()
{
	int ret = 0;
	char board[3][3] = { 0 }; 
	InitBoard(board);
	show(board);
	while (1)
	{
		playerMove(board);
		show(board);
		PcMove(board);
		printf("pc moved:\n");
		show(board);
		ret = IsWin(board);
		if (ret != ' ')
		{
			break;
		}

	}
		if (ret == 'X')
		{
			printf("you win");
		}
		if (ret == ' ')
		{
			printf("平局");
		}
		if (ret == 'o')
			printf("you are a loser");
}

//


int main()
{
	char board[row][col] = { 0 };
	menu();
	system("pause");
	return 0;
}