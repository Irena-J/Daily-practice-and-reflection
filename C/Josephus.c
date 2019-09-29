#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<windows.h>
int main(void)
{
	int total;      //�ܵı����
	int out;        //���ֵı��
	int start;      //��ʼ���

	printf("Please enter the total people\n");
	scanf("%d", &total);
	printf("Please enter the out number\n");
	scanf("%d", &out);
	printf("Please enter the start position\n");
	scanf("%d", &start);

	int people[total];        //��������ĳ���
	int i = start - 1;      //������ֵı��
	int count = 0;          //������ֵı��Ĭ�ϱ�Ϊ0
	int remain = total;     //����ÿ�γ��ֺ������

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

