class Person{
	String name;
	int age;
	static String dynasty;
	public Person(){
		
	}
	public Person(String name,int age){
		this.name= name;
		this.age = age;
	}
	public Person(String name,int age,String dynasty){
		this.name = name;
		this.age = age;
		this.dynasty = dynasty;
	}
	public void show(){
		System.out.println("name"+name+"age"+age+"dynasty"+dynasty);
	}
	public String getName(){
		return name;
	}
	//public void setName(Person p1,String name){
		//p1.name = name;
	//}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}	
}
public class PersonDemo{
	public static void main(String[] args){
		Person p1 = new Person("王阳明",3,"明");
		p1.show();
		Person p2 = new Person("徐阶",15);
		p2.show();
		Person p3 = new Person("白居易",18);
		p3.show();
		p3.dynasty="唐";
		p1.show();
		//System.out.println(p1.getAge());
		p1.setAge(999);
		System.out.println(p1.getAge());
		//p1.setName("张居正");
		//System.out.println(p1.getName());
		//p1.setName(p1,"王保保");
		//System.out.println(p1.getName());
	}
}
















