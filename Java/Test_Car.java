class Car{
	private String name;
	private String brand;
	private String color;
	private boolean type;
	
	public Car(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public String getBrand(){
		return this.brand;
	}
	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public boolean isType(){
		return this.type;
	}
	public void setType(boolean type){
		this.type = type;
	}
	public String getDescription(){
		return "name"+this.getName()+"color"+this.color+this.type;
	}
}
public class Test_Car{
	public static void main(String[] args){
		//多个对象可以分别创建对象
		Car C1 = new Car("WL1101");
		Car C2 = new Car("WL1110");
		C1.setColor("white");
		C2.setBrand("Star");
		C1.setType(false);
		String Str = C1.getDescription();
		System.out.println(Str);
		//也可以通过数组
		Car[] c1 = new Car[]{new Car("Wl"),new Car("ww")};
		//赋值操作
		c1[0].setBrand("ft");
	}
}
