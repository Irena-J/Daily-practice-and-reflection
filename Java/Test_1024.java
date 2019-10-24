//2、设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
class Car{
	private String brand;
	private String color;
	private String type;
	public Car(String brand){
		this.brand = brand;
	}
	public Car(String type,String color){
		this.type = type;
		this.color = color;
	}
	public String getType(){
		return type;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public void driveType(String type){
		if(type=="手动挡"){
		System.out.println("手动挡安全！");
		} else{
			System.out.println("自动挡好学！");
		}
	}
	public String getInfo(){
		return this.brand+"颜色"+getColor();
	}
		
}

public class Test_1024{
	public static void main(String[] args){
		Car[] Ca1 = new Car[]{new Car("MINI"),new Car("越野车","红色")};
			Ca1[0].setColor("白色");
			System.out.println(Ca1[0].getInfo());
			Ca1[0].driveType("手动挡");
	}
}










