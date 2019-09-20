#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#define ROW 9
#define COL 9
#define ROWS ROW+2
#define COLS COL+2
#define MINENUM 10


void mean()
{
	printf("======É¨À×ÓÎÏ·======");
	printf("****** 1.play ******");
	printf("****** 2.exit ******");
	pritnf("please input your choice\n");
	int num = 0;
	scanf("%d", &num);
	switch (num)
	{
	case 1:
		play();
		break;
	case 2:
		break;
	default:
		printf("please input 1 or 2");
		menu();
	}
}

void Init_board(char board[][COL],char set)
{
	int i = 0;
	for (i = 0; i < ROW; i++)
	{
		int j = 0;
		for (j = 0; j < COL; j++)
			board[i][j] == set;
	}
}

void ShowBoard(char board[][COLS])
{
	int i = 0;
	printf("\n");
	for (i = 0; i < ROWS - 1; i++)
	{
		printf("%d", i);
	}
	printf("\n");
	for (i = 1; i < ROWS - 1; i++)
	{
		printf("%d", i);

		int j = 0;
		for (j = 1; j < COLS - 1; j++)
		{
			printf("%c\t  ", board[i][j]);
		}
		printf("\n");
	}
}

void SetMine(char mine[][COL])
{
	int count = MINENUM;
	int x = 0;
	int y = 0;
	while (count != 0)
	{
		x = rand() % ROW + 1;
		y = rand() % COL + 1;
		if (mine[x][y] == '0')
		{
			mine[x][y] = '1';
			count--;
		}
	}
}

int GetMine(char mine[][COLS], int x, int y)
{
	return mine[x - 1][y - 1] - '0'+
		mine[x - 1][y] - '0'+
		mine[x - 1][y + 1] - '0'+
		mine[x][y + 1] - '0'+
		mine[x + 1][y + 1] - '0'+
		mine[x + 1][y] - '0'+
		mine[x + 1][y - 1] - '0'+
	mine[x][y - 1]-'0';
}


void FineMine(char mine[][COLS],char mineInfo[][COLS])
{
	int x = 0;
	int y = 0;
	int count = 0;
	while (count < ROW*COL - MINENUM)
	{
		peinrf("please input ");
		scanf("%d%d", &x, &y);
		if (x>=1 && x <= 9 && y >=1 && y <= 9)

		{
			if (mine[x][y] == '1')
			{
				printf("dead");
				break;
			}
			else
			{
				int mineNum = GetMine(mine, x, y);
				mineInfo[x][y] = mineNum + '0';
			}
		}
		if (count == ROW*COL - MINENUM)
		{
			printf("you win");
		}
	}
}


void play()
{
	int x = 0;
	int y = 0;
	char mineInfo[ROWS][COLS];
	char mine[ROWS][COLS];
	InitBoard(mineInfo,'$');
	InitBoard(mine,'0');
	ShowBoard(mineInfo);
	SetMine(mine);
	ShowBoard(mineInfo);
	FindMine(mine,mineInfo);
	GetMine(mineInfo,x,y);
}

int main()
{
	char minInfo[ROW][COL];
	char mine[ROW][COL];
	sysytem("puase");
	return 0;
}