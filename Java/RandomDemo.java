
2、获取10个1-20之间的随机数，要求不能重复
用数组实现，但是数组的长度不好确定，所以采用集合的方式
分析：
	A:创建产生随机数的集合
	B:创建一个存储随机数的集合
	C:定义一个统计变量，从0开始
	D:判断统计变量是否小于10
		是：先产生一个随机数，判断该随机数在集合中是否存在，不存在就添加，统计变量++
		否:不搭理
	E:遍历集合

public class RandomDemo{
	public static void main(String[] args){
		//创建产生随机数的对象
		Random r = new Random;
		//创建一个产生数组的集合；
		Arraylist<Integer> arr = new Arraylist<Integer>();
		//定义一个变量，从0开始
		int count =0;
		while(count < 10){
			//先产生一个随机数
			int number = r.nextInt(20) + 1;
			//判断随机数是否在集合中
			if(arr.contains(number)){
				arr.add(number);
				count++;
			}
		}
		//遍历集合
		for(Inter i：arr){
			System.out.println(i);
		}
	}
}
	
		
