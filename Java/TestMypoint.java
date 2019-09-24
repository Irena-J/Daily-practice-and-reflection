/*
设计一个名为MyPoint的类，表示一个带坐标x的和y坐标的点，该类包括：
两个带get方法的数据域x和y，分别表示他们的坐标
一个创建点(0.0)的无参构造方法
两个数据域x和y各自的get方法
一个名为distance的方法，返回MyPoint类型的两个点之间的距离
一个名为distance的方法，返回指定x和y坐标的两个点之间的距离
画出该类的UML图，实现这个类，编写一个测试程序，创建两个点(0.0)和(10，30.5)
并显示他们之间的距离
*/

import java.util.Scanner;
class MyPoint{
	private double x;
	private double y;
	public MyPoint()
	{
		this.x = 0;
		this.y = 0;
	}
	public MyPoint(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double distance(MyPoint myPoint)
	{
		double s;
		s = Math.sqrt((x - myPoint.getX()) * (x - myPoint.getX())
				+(y - myPoint.getY()) * (y - myPoint.getY()));
		return s;
	}
	public double distance(double x,double y)
	{
		double s;
		s = Math.sqrt((this.x - x) * (this.x - x)
				+(this.y - y) * (this.y - y));
		return s;
	}
}

public class TestMypoint{    
   private static Scanner input;

public static void main(String args[]){
     input = new Scanner(System.in);
     MyPoint My1 = new MyPoint();
     MyPoint My2 = new MyPoint(input.nextDouble(),input.nextDouble());
     System.out.println("The distance1 is "+My1.distance(My2));
     System.out.println("The distance2 is "+My2.distance(0, 0));
 }
}
