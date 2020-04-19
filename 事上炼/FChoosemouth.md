day02 

```
A派生出子类B，B派生出子类C，并且在java源代码中有如下声明：
1. A a0 = new A();
2. A a1 = new B();
3. A a2 = new C();
以上三行的声明都是正确的，并且能够通过编译和运行
 
 多态：父类引用指向子类对象(统一操作作用于不同的对象，可以又不同的解释，产生不同执行结果)。多态允许以统一的风格编写程序，以处理繁杂的已存在的类和相关类。降低了维护的难度又节省了时间。(允许方法重名，参数和返回值可以是父类传入或返回)(比如生活中打印机，都叫打印机有黑白打印机和彩色打印机两种表现，但是本质上都是打印机)
 
 三个定义：父类定义子类构建、接口定义实现类构建、抽象类定义实体类构建
 两个方法：
 		 方法重载：一个类中同名不同参的方法
 		 方法重写：一个前提(继承关系中)、三个相同(子类中重写的方法与父类同名同参			同返回值类型)和两个规定(子类方法的范围限定不能比父类的小，不能抛出更多		  的异常)
 		 (注意final和static类型的不能重写你知道的吧)
 
 运行时多态：动态多态，其具体引用的对象在运行时才能确定。
 编译时多态：静态多态，在编译时就可以确定对象使用的形式。
 
 表现形式：
 	方法重载
 	方法重写
 	

```



day 15

```
编写一个函数，将两个数字相加。不得使用+或其他算术运算符，给定两个int A和B，请返回A+B的值

public int add(int A,int B) {
	if (A == 0) {
		return B;
	}
	if (B == 0) {
		return A;
	}
	// A^B 想加不进位，(A&B) << 1 进位不相加
	return add(A^B,(A&B)<<1);
}
```

```
饥饿的小易
最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能移动到 4 * x + 3或者8 * x + 7。最多100,000移动次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要移动多少次就能吃到贝壳。

1> 4x+3 和 8x+7的数学操作，可以用二进制的左移和补1表示

	y = 4*x+3，相当于x的二进制左移2位，空位补1，即原先x的二进制为￥￥￥￥￥，则y  	   的二进制为￥￥￥￥￥11；y = 8*x+7,相当于y的二进制左移3位，然后空位补1，即原	先x的二进制为￥￥￥￥￥，则y二进制为￥￥￥￥￥111；

2> 小易得移动，最终可以表达成 4x+3操作进行了m次，8x+7操作进行了n次

	4*x+3操作进行m次，则x的二进制后面增加2m个1
	8*x+7操作进行n次，则x的二进制后面增加了3n个1
	小易的移动，最终可以表达为：x的二进制后面增加了（2m+3n）个1
	移动的顺序对其到达没有影响 why?
	
3> 小易移动次数的分析
	初始位置为0，则直接满足，需移动0次
	初始位置不为0，则记times=(2m+3n),m取1到10_0000,n取1到10——0000
	所以，times取值范围为[2,30_0000]。即：最多30_0000次搜索，就能获得结果。

public class Main {
    public static final long LIMIT = 300000;//最多搜索次数
    public static final long N = 1000000007;//求余

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(sol(sc.nextLong()));
        }
    }

    //次数判定方法
    public static long sol(long in){
        //如果初始位置为0，则直接可行，返回0次
        if(in == 0){
            return 0L ;
        }else{//初始位置不为0，则开始搜索
            return search(in);
        }
    }

    //不为0时的搜索
    public static long search(long in){//参数：初始坐标
        long temp = in;
        //遍历，获取最小位移
        for(int i=1;i<=LIMIT;i++){
            //long temp = (in+1)*(long)Math.pow(2,i)-1;//当循环较大时，幂次太高，数字超出范围，报错
            //递推
            temp = (temp * 2 + 1 ) % N;
            if( temp % N == 0 ){
                //i是符合条件的最小偏移，然后对其进行分解
                for(int j =0;j<=(i / 2);j++){//j对应a值
                    if((i - 2*j) % 3 == 0){
                        return ((i+j)/3);
                    }
                }
            }
        }
        //超过最大次数还没匹配，则输出-1
        return -1L;
    }
}


```

day 16

```
1.如果希望监听TCP端口9000，服务器端应该怎样创建socket？ new ServerSocket(9000)

2.下面哪个类的声明式正确的？
abstract final class HI{} //final式最终类，而abstract修饰需要继承后实现，
abstract private move(){} //private是私有，而abstact是抽象需要实现，冲突
// 另外既然是抽象方法不能有方法体
protected private number; // 修饰符重复且没有定义属性类型
public abstract class Car{}

java规定：The abstract method farther in type Test can only set a visibility modifier，one of public or protected
也就是抽象方法只能用 public 和 protected 修饰

修饰内部类：abstract不能与final共存(内部类四个访问权限控制符都可以)
修饰外部类：abstract不能与final、static共存：
	不能与final是由于抽象类必须被子类实现，而final标志不能被继承了。而声明	 	 static说明可以直接用类名调用方法，而又用abstrsct修饰说明里面的抽象类必须被虫 	   重写才能用，冲突。
修饰方法：abstract不能与final，static，private共用

3.接口的访问控制修饰符，由于所有都遵循所以可以省略
	接口名：public
	数据域：public static final
	方法：public abstract
	
4.jre判断程序是否结束的标准是？ 所有前台线程执行完毕。
	后台线程就是守护线程(比如gc)；前台线程就是用户线程(比如main)
	Thread 默认情况下创建的是前台线程；托干线程池中的线程都是后台线程
	不管是前台还是后台线程，如果线程内出现了异常，都会导致进程的终止。
	但凡有一个前台线程未退出，进程就不会终止；而后台线程只要所有前台线程都退出，进 	程就会终止
	
5. jdk1.6垃圾收集器有Serial收集器、parNew收集器、CMS收集器

6. instanceof运算符能够用来判断一个对象是否为一个类的实例、一个实现指定接口的  	 	类的实例、一个子类的实例
   instance 是java 的二元运算符，用来判断他左边的对象是否为右边类、接口、抽象    	  类、父类的实例
   
7. java中类型转换规则：低阶自动高阶转换，高阶可强制转换低阶；但是有两种情况注意：
	char和short虽然都是两个字节但是char是字符型，short是短整型，不能互转
	char的范围是(0-65535;'\u0000'到‘\uffff’的uniicode字符),不存在负数，能 	   表示的数据是0-255，如数字、字母等。
	
	另外float能表示的范围其实远远大于long，这是因为浮点数存储方式引起的。
```

![image-20200419153650702](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200419153650702.png)

```
洗牌：
现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。

思路：暴力破解，每次取一个数之后，算出经过k次洗牌后的位置，只用一个长度为2n数组用来输出，根据当前数的位置，可以算出经过一次洗牌后的位置：
如果当前数小于等于n(即再左手)，则下次出现的位置是2*当前位置-1；
如果当前数大于n(即在右手)，则下次出现的位置是2*(当前位置-n)；

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int groups = sc.nextInt();
		while ((groups--) > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] res = new int[2*n];
			for (int i = 0; i < 2*n; i++) {
				int tmp = i + 1;
				for (int j = 0; j < k; j++) {
					if (tmp <= n) {
						tmp = 2*tmp - 1;
					} else {
						tmp = 2*(tmp-n);
					}
				}
				res[tmp - 1] = sc.nextInt();
			}
			//输出
			if(res.length > 0) {
				System.out.println(res[0]);
			}
			for (int i = 1; i < 2*n; i++) {
				System.out.print(" "+res[i]);
			}
			System.out.println();
		}
	}
}

// 统计同成绩人数
暴力，也可以用map
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			if (N ==0) {
				return;
			}
			int[] arr = new int[N]; // 保存n个人的分数
			for (int i =0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int t = sc.nextInt(); // 目标分数 输出几种目标分数的个数
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (t == arr[i]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}

map

import java.util.Scanner;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			HashMap<Integer,Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.merge(sc.nextInt(),1,Integer::sum);
			}
			System.out.println(map.getOrDefault(sc.nextInt(),0));
		}
	}
}
```

