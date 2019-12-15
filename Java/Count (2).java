//统计字符串中大写字母和小写字母和数字分别出现的次数

public static void Count(){
	//定义单个变量
	int bigCount = 0；
	int smallCount = 0；
	int numberCount = 0；
	char[] ch = str.toCharSrray
	
	//录入字符串
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入一个字符串");
	String line = sc.nextLine();
	//遍历数组获取到每一个字符
	for(int i = 0;i < ch.length;i++){
		char chs = ch[i];
		
		if (Character.isUpperCase(chs)){
			bigCount++；
		} else if (Character.isLowerCase(chs)) {
			smallCount++;
		} else if (Character.isDigit(chs)){
			numberCount++;
		}
	}
}