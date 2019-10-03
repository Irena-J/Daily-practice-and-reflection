typedef struct Day
{
	int year;
	int month;
	int day;
}Day;//2019 9 21


int Today(Day day)
{
	int arr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int total = 0;
	if(day.year%4 == 0 && day.year%100 !=0 
		|| day.year%400 == 0)
	{
		arr[1] = 29;
	}

	switch (day.month)
	{
		case 12:
			total = total+arr[10];
		case 11:
			total = total+arr[9];
		case 10:
			total = total+arr[8];
		case 9:
			total = total+arr[7];
		case 8:
			total = total+arr[6];
		case 7:
			total = total+arr[5];
		case 6:
			total = total+arr[4];
		case 5:
			total = total+arr[3];
		case 4:
			total = total+arr[2];
		case 3:
			total = total+arr[1];
		case 2:
			total = total+arr[0];
		case 1:
			total = total+day.day;
		default:
			break;
		}
		return total;
}

int main()
{
	Day day = {2019,9,21};
	int today = Today(day);
	printf("%d\n",today);
	return 0;
}

