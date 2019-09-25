/*创建名为Comparable的类，它继承Circle类并实现Comparable接口，画出UML图并实现
comparaTo方法，使其根据面积比较两个圆。编写一个测试程序求出ComparableCircle
对象的两个实例的较大者*/
interface Comparable{
	public abstract int comparaTo(Object o);
}

public class Circle extends GeometricObject{
	private double radius;
	public Circle(){
	}
	public Circle(double radius){
		this.radius=radius;
	}
	public Circle(double radius,String color,boolean filled){
		this.radius=radius;
		setColor(color);
		setFilled(filled);
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getArea(){
		return radius*radius*Math.PI;
	}
	public void printCircle(){
		System.out.println("The circle is created"+getDateCreated()+"and the radius ");
	}
}

public class ComparableCircle extends Circle implements Comparable{
	public ComparableCircle(){
		
	}
	public ComparableCircle(double radius){
		super(radius);
	}
	public int comparaTo(ComparableCircle o){
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else 
			return 0;
	}
	public String toString(){
		return super.toString()+ "Area:"+getArea();
	}
}

public class TextCircleArea{
	public static void main(String[] args){
	ComparableCircle C = new ComparableCircle(3);
	ComparableCircle C2 = new ComparableCircle(3);
	
	System.out.println(Math.max(C,C2));
	}
}




