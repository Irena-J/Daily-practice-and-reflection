//1、编写一个类Calculator,有两个属性num1,num2,这两个数据的值，
//不能在定义的同时初始化，最后实现加减乘 除四种运算. 
//2、设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。 
//3、实现交换两个变量的值。要求：需要交换实参的值。

class Calcutor{
	private double num1;
	private double num2;
	public Calcutor(){}
	public Calcutor(double num1,double num2){
		this.num1=num1;
		this.num2=num2;
	}
	public double getNum1(){
		return num1;
	}
	public double getNum2(){
		return num2;
	}
	public double add(double num1,double num2){
		return num1+num2;
	}
	public double minus(double num1,double num2){
		return num1-num2;
	}
	public double multiply(double num1,double num2){
		return num1*num2;
	}
	public double div(double num1,double num2){
		return num1/num2;
	}
}
public class Test1024{
	public static void main(String[] args){
		Calcutor Ca1 = new Calcutor();
		System.out.println(Ca1.div(10.0,5.0));
	}
}


















