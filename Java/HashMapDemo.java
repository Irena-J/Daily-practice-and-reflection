集合的遍历：
HashMap<String,String>
键：String
值：String

	public class HashMapDemo1 {
		public static void main(String[] args){
			//创建集合对象
			HashMap<String,String> hm = new HashMap<String,String>();
			
			//添加集合元素
			hm.put("it001","裘伯君");
			hm.put("it002","张朝阳");
			hm.put("it003","马化腾");
			hm.put("it004","马云");
			hm.put("it001","比尔盖茨");
			
			//按照键找值遍历
			Set<String> set = hm.keySet();
			for(String key : set){
				String value = hm.get(key);
				System.out.println(key+"---"+value);
			}
		}
	}
	
HashMap<Integer,String>
键：Integer
值：String

	public class HashMapDemo2 {
		public static void main(String[] args) {
			//创建集合对象
			HashMap<Integer,String> hm = new HashMap<Integer,String>();
		
			//创建元素并添加元素
			//Integer i = new Integer(20);
			//Integer i = 20;//自动拆装箱
			//String s = "the shy"
		
			//hm.put(i,s);
			hm.put(20,"the shy");
			hm.put(19,"jacklove");
			hm.put(21,"rookie");
			hm.put(22,"leyan");
			hm.put(18,"leyan"); //前面的年龄都是十进制数字
		
			//hm.put(006,"leyan");
			//hm.put(008,"leyan"); 注意这里会报错，因为是以0开头就是八进制数据
		
			//遍历
			Set<integer> set = hm.keySet();
			for(Integer key : set) {
				String value = hm.get(key);
				System.out.println(key+"---"+value);
			}
		}
	}
	
	HashMap<String,Student>

键：String
值：Student

	public class HashDemo3 {
		public static void main(String[] args) {
			//创建集合对象
			HashMap<String,Student> hm = new HashMap<String,String>();
			
			//创建学生集合对象
			Student s1 = new Student("the shy",19);
			Student s2 = new Student("rookie",21);
			Student s3 = new Student("leyan",18);
			
			//添加元素
			hm.put("202001",s1);
			hm.put("202002",s2);
			hm.put("202003",s3);
			hm.put("202004",s4);
			
			//遍历
			Set<String> set = hm.keySet();
			for(String key : set) {
				//注意此时键对应的值的类型是什么
				Student value = hm.get(key);
				//注意这里的访问记得要重写toString()或者调用访问器方法
				System.out.println(key+"--"+value.getName()+"--"+value.getAge());
			}
		}
	}
	
	
HashMap<Student,String>

键：Student
	要求：如果两个对象的成员变量值都相同,则为同一个对象
值：String

	public class HashMapDemo4 {
		public static void main(String[] args) {
			//创建集合对象
			HashMap<Student,String> hm = new HashMap<Student,String>();
			
			//创建学生对象
			Student s1 = new Student("leyan",18);
			Student s2 = new Student("the shy",19);
			Student s3 = new Student("rookie",21);
			Student s4 = new Student("the shy",19);
			
			//添加元素
			hm.put(s1,"202001");
			hm.put(s2,"202002");
			hm.put(s3,"202003");
			hm.put(s4,"202004");
			
			//遍历
			Set<Student> set = hm.keySet();
			for(Student key : set) {
				String value = hm.get(key);
				//根据要求为了防止s4的重复要在Student中重写hashCode和equals方法
				//键相同值覆盖
				System.out.println(key.getName()+"———"+key.getAge+"--"+value);
			}
		}
	}




















	