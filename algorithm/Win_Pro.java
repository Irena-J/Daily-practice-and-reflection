// write your code here
// n个人又n！种抽奖方式，自己没抽到自己情况又(n-1)!种，无人想法是不全的，默认了每个人在抽取的时候他的名字依然还存在
// 事实上在这个不放回事件中有两种可能，一种是自己的名字还在，另外一种是自己的名字不在，并且每个人都有这种情况
// 所以属于一个递归问题
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            /*
            int n = sc.nextInt();
            int sum = 1;
            for (int i = n; i > 1; --i) {
                sum *= i;
            }
            int a = sum/n;
            System.out.println(String.format("%.2f",(100.00/n))+"%");
            */
            
            int n = sc.nextInt();
            int sum = 1;
            // 先计算总的抽取可能的情况
            for (int i = n; i > 1; --i) {
                sum *= i;
            }
            double ret = 100*count(n)/(double)sum;
            System.out.println(String.format("%.2f",ret)+"%");
        }
    }
    
    // 计算出所有不中奖的情况
    // 这里需要注意递推的终止条件
     public static int count(int n) {
            if(n == 1){
                return 0;
            }
            if(n == 2){
                return 1;
            }
            return (n-1)*(count(n-1)+count(n-2));
        }
}