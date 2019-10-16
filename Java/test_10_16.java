import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

public class Test_1016 {
    public static void main(String[] args) {
        System.out.println(getSum(5));
        printNum(1234);
        System.out.println(getSum2(1729));
        System.out.println(fib2(4));
        System.out.println(jumpStiar(5));
        System.out.println(jumpStair(4));
    }
    public static int getSum(int n){
        if(n==1){
            return 1;
        }
        return n+getSum(n-1);
    }
    public static void printNum(int num){
        if(num>9){
            printNum(num/10);
        }
        System.out.println(num%10);
    }
    public static int getSum2(int num){
        if(num<10){
            return num;
        }
        return getSum2(num/10)+getSum2(num%10);
    }
    public static int fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
    public static int fib2(int n){
        int num1=1;
        int num2=1;
        int num3=1;//这里要么初始化为1，要么提前判断下
        int i=3;
        for(;i<=n;i++){
           num3=num2+num1;
           num1=num2;
           num2=num3;
        }
        return num3;
    }
    public static int jumpStiar(int n){
        if(n==1){
            return 1;
        }if(n==2){
            return 2;
        }
        return jumpStiar(n-1)+jumpStiar(n-2);
    }
    public static int jumpStair(int n){
        if(n<=2){
            return n;
        }
        int num1=1;
        int num2=2;
        int num3=3;
        for(int i=3;i<=n;i++){
            num3=num1+num2;
            num1=num2;
            num2=num3;
        }
        return num3;
    }
}
