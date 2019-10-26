public class Test1024{
	String num1;
	String num2;
	public Test1024(){}
	public  void sweap(String num1,String num2){
		String temp = num1;
		this.num1 = num2;
		this.num2 = temp;
	}
	public static void main(String[] args){
		Test1024 a = new Test1024();
		a.sweap("1","2");
		System.out.println(a.num1);
		System.out.println(a.num2);
	}
}