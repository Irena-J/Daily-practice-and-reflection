public class ArrayListDemo2{
	public static void main(String[] args){
		//创建新的元素对象
		ArrayList arr1 = new ArrayList();
		//添加多个字符元素(包含重复的内容)
		arr1.add("hello");
		arr1.add("world");
		arr1.add("java");
		arr1.add("hello");
		arr1.add("world");
		arr1.add("java");
		arr1.add("world");
		//分别拿每一个索引和后面的比较
		for(int x = 0; x < arr1.size(); x++){
			for(int y = x+1; y < arr1.size(); y++){
				if(arr1.get(x).equals(arr1.get(y))){
					arr.remove(y);
					y--;//当出现连续重复的时候
				}
			}
		}
		//遍历集合
		Iterator it = arr2.iterater();
		while(it.hasNext()){
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}