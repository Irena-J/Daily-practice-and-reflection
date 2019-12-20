import java util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

class Student{
		private String name;
		private int age;
		
		public Student(){}
		publc Student(String name,int age){
			this.name = name;
			this.age = age;
		}
		public String getName(){
			return this.name;
		}
		public int age(){
			return thia.age;
		}
	}
	public class StudentDemo{
		publlic static void main(String[] args){
			Collection c = new ArrayList();
			Student s1 = new Student("lily",3);
			Student s2 = new Student("Jokesia",18);
			Student s3 = new Student("hebi",22);
			
			c.add(s1);
			c.add(s2);
			c.add(s3);
			//由于作用在局部，用完就回收了，效率比较高
			for(Iterator it = c.iterator();it.hasNext();){
				Student s = (Student) it.next();
				System.out.println(s);
			}
		}
	}