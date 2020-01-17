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