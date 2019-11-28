//统计录入一个字符串中大写字母字符，小写字符出现的次数(不考虑其他字符)
eg："Hello123World"
分析：
A：定义三个统计变量
	bigCount = 0
	smallCount = 0
	numberCount = 0
B：遍历字符串，得到每一个字符
	length()和charAt()结合
C: 判断该字符到底是属于哪种类型
	大：bigCount++  小：smallCount++    数字：numberCont++
突破口：ASSII表：这样是可以的
		0：48	A：65	a：97
		或者'0'	'9'	'a'	'z'	'A'	'Z'	
		
public void Count(){
	int bigCount = 0;
	int smallCount = 0;
	int numberCount = 0;
	Scanner sc = new Scanner(System.in);
	Scanner ch = sc.nextLine();
	
	for(int i = 0; i < ch.length(); i++){
		char cr = charAt(i);
		//判断字符是属于那种类型
		if(cr >= 'a' && cr <= 'z'){
			smallCount++;
		}else if(cr >= 'A' && cr <= 'Z'){
			bigCount++;
		}else{
			numberCount++;
		}
	}
	System.out.println("大写字符是："+bigCount+"个");
	System.out.println("小写字符是："+smallCount+"个");
	System.out.println("数字是："+numberCount+"个");
	

}	