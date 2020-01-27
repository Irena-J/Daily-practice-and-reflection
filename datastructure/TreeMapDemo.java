//统计字符串中每个字符出现得次数
	eg："aababcabcdabcde"获取每个字符串中每一个字母出现得次数要求结果：
		"a(5)b(4)c(3)d(2)e(1)"
		思路：
			A：定义一个字符串
			B：定义一个Map集合
			C：把字符串转换为字符数组
			D: 遍历字符数组，得到每一个字符
			E: 拿这个字符到Map集合中去找，看返回值
					是null：就把这个字符作为键，1就为值存储
					不是null：就把值++，然后重新存储该键和值
			F：定义一个字符串缓冲区
			G：遍历TreeMap集合，获取每一个键值对元素拼接
			H: 把字符串缓冲区转换为字符串输出
			
public class TreeMapDemo {
	public static void main(String[] args){
		//定义一个字符串
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String line = sc.nextLine();
		
		//定义一个TreeMap集合
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		
		//把字符串转换为字符数据
		char[] chs = line.toCharArray();
		
		//遍历字符数组，得到每一个字符
		for(char ch : chs) {
			//拿刚才得到得字符作为集合中去找值，看返回值
			Integer i = tm.get(ch);
			
			//是null，说明该键不存在，就把这字符作为键，1作为值存储
			if(i == null) {
				tm.put(ch,1);
			} else {
				//不是null，说明该键存在，就把值加1，然后重新存储该键和值
				i++; //自动拆箱，加加后再自动装箱
				tm.put(ch,i);
			}
		}
		定义字符串缓冲区
		StringBuilder sb = new StringBuilder();
		
		//遍历集合，得到键和值，进行按照要求拼接
		Set<Character> set = tm.keySet();
		for(Character key : set) {
			Integer value = tm.get(key);
			sb.append(key).append("(").append(value).append(")");
		}
		//把字符串缓冲区转换为字符串输出
		String result = sb.toString();
		System.out.println("result:"+result);
	}
}