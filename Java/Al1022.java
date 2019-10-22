 class HelloA(){
	//构造方法
	public HelloA(){
		System.out.println("1Hello A!父类构造方法");
	}
	//非静态代码块
	{
		System.out.println("2im A class.父类非静态代码块");
	}
	//静态代码块
	static {
		System.out.println("3static A 父类静态代码块");
	}
}
class HelloB extends helloA{
	//构造方法
	public HelloB(){
		System.out.println("4Hello B! 构造方法");
	}
	//非静态代码块
	{
		System.out.println("5im B class.非静态代码块");
	}
	//静态代码块
	static{
		System.out.println("6 static B 静态代码块")；
	}
}
public class AL1022{
	public static void main(String[] args){
		System.out.println("7----satrt----");
		new HelloB();
		new HelloB();
		System.out.println("8----end-----");
	}
}

//执行顺序：36721548
