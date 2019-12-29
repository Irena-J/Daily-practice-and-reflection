//获取10个1-20之间的随机数，要求不能重复

import java.util.ArrayList;
import java.util.Random;

//获取10个1-20之间的随机数，要求不能重复
//用数组实现，但是数组的长度是固定，长度不好确定
//所以可以使用集合实现

//分析：
//A:创建产生随机数的对象
//B：创建一个存储随机数的集合
//C：定义一个统计变量，从0开始
//D: 判断统计变量是否小于10
	//是：先产生一个随机数，判断该随机数在集合中是否存在
		//不存在：添加，统计变量++
		//存在：就不搭理
	//否：不搭理
//E：遍历集合

public class RandomDemo{
	public static void main(String[] args){
		//创建产生随机数的对象
		Random r = new Random();
		//创建一个存储随机数的集合
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//定义一个统计变量，从0开始
		int count = 0；
		
		//判断统计遍历是否小于10
		while(count < 10){
			//先产生一个随机数
			int number = r.nextInt(20)+1;
			
			//判断该随机数在集合中是否存在
			if(!arr.contains(number)){
				//如果不存在就添加，统计变量++
				arr.add(number);
				count++;
			}
		}
		//遍历集合
		for(Integer i : arr){
			System.out.println(i);
		}
	}
}

public class HashSetDemo{
	public static void main(String[] args){
		//创建随机对象
		Random r = new Random();
		//创建一个Set集合
		HashSet<Integer> ts = new HashSet<Integer>();
		//判断集合的长度是不是小于10
		while(ts.size() < 10) {
			int num = r.nextInt(20) + 1;
			is.add(num);
		}
		for(Integer i : ts){
			System.out.println(s);
		}
	}
}



















