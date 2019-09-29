#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<windows.h>
int main(void)
{
	int total;      //总的编号数
	int out;        //出局的编号
	int start;      //起始编号

	printf("Please enter the total people\n");
	scanf("%d", &total);
	printf("Please enter the out number\n");
	scanf("%d", &out);
	printf("Please enter the start position\n");
	scanf("%d", &start);

	int people[total];        //定义数组的长度
	int i = start - 1;      //定义出局的编号
	int count = 0;          //定义出局的编号默认变为0
	int remain = total;     //定义每次出局后的总数

	int j = 0;
	for (j = 0; j < total; j++)
		people[j] = j + 1;

	printf("begin to solve josephus's problem.\n");
	for (j = 0; j < total; j++)
		printf("%d ", people[j]);
	printf("\n");

	while (1)
	{
		if (people[i] > 0)
		{
			count++;
		}
		else
		{
			i++;
			if (i == total)
				i = 0;
			continue;
		}

		if (count == out)
		{
			printf("The people of %d is out.\n", people[i]);
			people[i] = 0;
			count = 0;
			remain--;
		}

		i++;
		if (i == total)
			i = 0;

		if (remain == 0)
			break;

	}

	printf("Josephus has solved his problem\n");
	system("pause");
	return 0;
}

