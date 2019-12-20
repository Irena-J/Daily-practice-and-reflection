//键盘录入多个数组，以0结束，要求在控制台输出这多个数据的最大值

分析:
	A:创建键盘录入数据对象
	B:键盘录入多个数据，不确定数量，所以可以采用集合
	C:以0结束,0就不继续录入
	D:把集合转换数组，对数组进行排序，找出数组中最大的
	
public class ArryListDemo4{
	public static void main(String[] args){
		//创建键盘录入数据
		Scanner sc = new Scanner(System.in);
		//键盘录入多个数据，不确定数量，所以用集合
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		//以0结束
		while(true){
			System.out.println("请输入数据：");
			int number = sc.nextInt();
			if (number != 0) {
				arr.add(number);
			} else {
				break;
			}
		}
		//把集合转换数组：可以用这个方法 Object[] toArray()
		//另外一种 泛型
		//public <T> T[] toArray(T[] a){
		Integer[] i = new Integer[arr.size()]; 下面这个i和ii其实是同一个，所以可直接拿来用
		//Integer[] ii = arr.toArray(i);
		arr.toArray(i);
		//对数组进行排序 public static void sort(Object[] a)
		Arrays.sort(i);
		//获取该数组的最大索引值
		System.out.println("数组是："arrayToString(i)+ "最大值是："i.(i.length - 1));
		}	
	}
	public static String arrayToString(Integer[] i){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int x = 0; x < i.length; x++){
			if(x == i.length -1){
				sb.append(i[x]);
			} else {
				sb.append(i[x].append(","));
			}
		}
		sb.append("]");
		return sb.toString();
	}
}