public class ArrayListDemo{
	public static void main(String[] args){
		//创建集合对象
		ArrayList arr = new ArrayList();
		//添加多个字符串元素(包含内容相同的)
		arr.add("hello");
		arr.add("world");
		arr.add("java");
		arr.add("hello");
		arr.add("world");
		arr.add("java");
		arr.add("world");
		
		//创建新的集合
		ArrayList newArr = new ArrayList();
		
		//遍历旧的集合，采用迭代器
		Iterator it = arr.iterator();
		while(hasNext()){
			String s = (String)arr.iterator();
			//拿到这个元素集合去找，看有没有一样的
			if(!newArr.contains(s)) {
				newArr.add(s);
			}
		}
		//遍历新集合
		for(int x = 0; x < newArr.aize(); x++){
			String s = (String) newArr.get(x);
			System.out.println(s);
		}
	}
}