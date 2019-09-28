#define _CRT_SECURE_NO_WARNINGS 1

int main()
{
	int a[500];
	int i;
	for (i = 0; i < 500; i++)
	{
		a[i] = -1 - i;
	}
	printf("%d", strlen(a));
	system("pause");
	return 0;
}