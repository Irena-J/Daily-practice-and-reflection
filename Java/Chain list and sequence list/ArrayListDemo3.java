//存储字符串的三种遍历方式
public class ArratListDemo3{
	public static void main(String[] args){
	//创建集合对象
	ArrayList<String> arr = new ArrayList<String>();
	
	//创建并添加元素
	arr.add("hello");
	arr.add("world");
	arr.add("java");
	
	//遍历集合
	//迭代器
	Iterator<String> it = arr.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	
		//普通for
		for(int x = 0; x < arr.size(); x++){
			String s = arr.get(x)
			System.out.println(s);
		}
	
		//增强for
		for(String s : arr){
			System.out.println(s);
		}
	}
}