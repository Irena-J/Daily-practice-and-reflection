//以空格分割两个字符串
public static String func(String str){
	String[] str2 = str.spilt(" ");
	String ret = "";
	for(String s : strs){
		ret += s;
	}
	return ret;
}
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	String ret = func(str);
	System.out.println(ret);
}