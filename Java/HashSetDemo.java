//HashSet保证元素唯一性的体现
public class HashSetDemo{
	public int hashCode(){
	//return 0; 这样并不好，添加的时候是一个桶结构，效率低下
	//而因为哈希值和对象的成员变量值相关，解决办法就是把对象的成员变量值相加(对于基本类型就直接加值，对于引用类型就加哈希值)
	
	return this.name.hashCode() + this.age*15
	}

	public boolean equals(Object obj){
		System.out.println(this+"---"+obj);
		if(this == obj){
			return true;
		}
		Student s = (Student) obj;
		return this.name.equals(s.name) && this.age == s.age;
	}
	public String toString(){
		return "Student [name =" + name+",age ="+age+"]";
	}
}