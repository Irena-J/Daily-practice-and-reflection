[TOC]

## April

### day 01 【统计回文】

编程题

```
// 统计回文

import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;

// 先暴力
// 把 b 放到 a 中的每一个位置，定义一个计数器，一旦判断是回文串就+1，最后输出结果

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strA = sc.nextLine();
            String strB = sc.nextLine();
            int count = 0;
            int len = strA.length();
            for (int i = 0; i <= len;++i) {
                StringBuilder sb = new StringBuilder(strA);
                sb.insert(i,strB);
                if (isPa(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    // 判断回文串
    public static boolean isPa(String str) {
        int lan = str.length();
        int tmp = lan-1;
        for (int i = 0; i < lan; ++i) {
            if (str.charAt(i) != str.charAt(tmp)) {
                return false;
            } 
            if (tmp != i) {
                tmp--;
            }
        }
        return true;
    }
}
```



### day 02

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

编程题

```
1.汽水瓶问题
这个题需要把前后关系理清楚
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = 0;
            while (n > 2) {
                sum += n / 3;
                n = n / 3 + n % 3;
            }
            if (n == 2) {
                System.out.println(sum+1);
            } else {
                System.out.println(sum);
            }
        }
    }
}
```

```
2.数组中的逆序对
import java.util.*;

public class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
        // 先暴力破解
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = i+1; j < A.length; ++j) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

方式一采用暴力破解的方式，遍历了两次数组，时间复杂度式O(n^2);可以优化
优化：
利用分治思想处理，先分治，把数组分隔成子数组，统计出子数组的逆序对数目，然后再统计相邻子数组之间逆序对的数目，在统计逆序对的过程中，还需要对数组进行排序，其实这是归并排序的思路。

在理解了过程之后，如果迷糊究极注意多路递归的这个return，每一个跟着return不迷路。
```



### day 13 【跟奥巴马一起编程】【超长整数相加】

```
选择题
1. 关于JVM内存，如下图
```

![img](https://uploadfiles.nowcoder.com/images/20180701/3807435_1530422766821_56E98F2DF01A734BD7F1AF7A95A7C2D7)

```
5. java编译出来的目标文件，可以运行在任意jvm上，注意这句话成立要注意版本问题，就是高级的不能运行在低级的JVM上，jvm不能向上兼容哦；java运行时才进行指令翻译。
```

```
【跟奥巴马一起编程】

在屏幕上画一个正方形。

输入在一行中给出正方形N和组成正方形边的某种字符C，间隔一个空格
10 a

输出由给定字符C画出的正方形。但是注意到行间距比利间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%
aaaaaaaaaa
a		 a
a		 a
a		 a
aaaaaaaaaa

看成一部分处理，一个实心的正方形加中间的空格

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char c = sc.next().charAt(0);
		
		for (int i = 0; i < (N>>1); i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0 || i == (N>>1)-1 || j == N-1) {
					System.out.print(c);
				} else {
					System.out.print("");
				}
			}
			System.out.println("");
		}
	}
}

分三部分考虑，第一行、中间行和最后一行的处理
import java.util.Scanner;
public clss Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //输出的列数
		String c = sc.next(); //输出的字符
		for (int i = 1; i <= N; i++) { //输出第一行
			System.out.print(c);
		}
		System.out.print(c);
	}
	System.out.println(); // 第一行换行
	for (int i = 1; i <= Mth.ceil((double)N/2)-2; ++i) { //输出中间行
		System.out.print(c); // 中间行第一个字符
		for (int j = 2; j <= N-1; j++) {
			System.out.print(" "); //中间行其它字符为空字符
		}
		System.out.println(c); //中间行最后一个字符
	}
	for (int i = 1; i <= N; ++i) { //输出最后一行
		System.out.print(c);
	}
}
```



### day 14 【尼克彻斯定理】【组个最小数】

```
选择题
2、内存回收程序负责释放无用内存
3、流媒体技术是一种可以使用音频、视频和其他多媒体信息在Internet及Intranet上实时的，无需下载等待的方式进行播放的技术。
5、形式参数可以被视为local variable
6、下列哪种情况可以终止当前线程的运行？ 抛出一个异常时
8、SimpleDateFormat对象是线程不安全的
```

```
【组个最小数】

1、组个最小数：给定数组0-9各若干个。可以任意顺序排序这些数字，但必须全部使用。目标 是使得最后得到的数尽可能小(注意0不能做首位)。例如：给定两个0、两个1，三个5，一个8，我们得到的最小的数就是10015558。
eg:
输入：(10个数字的总个数不超过50，并且至少有一个非0的数字)
2 2 0 0 0 3 0 0 1 0
输出：
10015558
// 这个题的关键在于把题目读清

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; ++i) {
			// 存储0-9对应的出现次数
			arr[i] = sc.nextInt();
		}
		// 先把第一位数输出,注意0号位一定是0
		for (int i = 1; i < 10; ++i) {
			// 如果从1号位置也就是数字0往后的第一个出现次数不为0的输出
			if (arr[i] != 0) {
				System.out.print(i);
			}
		}
		// 输出 0 号位置的所有的0
		for (int i = 1; i < 10; ++i) {
			while (arr[0] != 0) {
				System.out.print(0);
				arr[0]--;
			}
		}
		// 最后按照 1-9的顺序输出，因为可能1不止出现一次,所以从1开始
		for (int i= 1; i < 10; i++) {
			while (arr[i] != 0) {
				System.out.println(i);
				arr[i]--;
			}
		}
	}
}
```

```
【尼克彻斯定理】

验证尼科斯彻定理，即：任何一个整数m的立方都可以写成m歌连续奇数之和。eg：
1^3 = 1
2^3 = 3+5
3^3 = 7+9+11
4^3 = 13+15+17+19

输入一个 int 整数
6

输出分解后的string
31+33+35+37+39+41

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int a = m*(m-1)+1;
			System.out.print(a)
			for (int i = 1; i < n; ++i) {
				System.out.print("+"+(a+=2));
			}
			// 注意OJ里面跑一定要加上这个换行
			System。out.prinltn();
		}
	}
}

import java.util.Scanner;
impirt java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int m = sc.nextInt();
			System.out.println(GetSequeOddNum(m))
		}
	}
	public static String GetSequeOddNum(int m) {
		ArrayList<Integer> array = new ArrsyList<Integer>();
		StringBuilder sb = new Stringbuilder();
		int sum = 0;
		for (int i = 0; i <= m; ++i) {
			sum += i;
		}
		int num = 1;
		array.add(num);
		for (int j = 1; j < sum; ++j) {
			num += 2;
			array.add(num);
		}
		for (int i = array.size()-m; i < array.size()-1; ++i) {
			sb.append(array.get(i));
			sb.append("+");
		}
		sb.append(array.get(li.size()-1));
		return sb.toString();
	}
}
```



### day 15 【两数相加】【 饥饿得小易】

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

### day 16 【洗牌】 【统计同成绩人数】

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

