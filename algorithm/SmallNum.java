import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        
        for (int i = 0; i < 10; ++i) {
            arr[i] = sc.nextInt();
        }
        
        // 先输出第一位数字从1开始，因为0号位置一定是0，
        for (int i = 1; i < 10; ++i) {
            if (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        // 输出0,题目说了至少有一个非0的数
        while (arr[0] != 0) {
            System.out.print(0);
            arr[0]--;
        }
        // 最后顺序输出剩下的数1-9的顺序，注意要从1开始，因为可能有多个
        for (int i = 1; i < 10; ++i) {
            while (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
            }
        }
    }
}



// 请把题意读清除

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int[] arr = new int[10];
            for (int i = 0; i < 10;) {
                int n = sc.nextInt();
                int tmp = n;
                int j = i;
                if (n == 0) {
                    i++;
                    continue;
                }
                while (n > 0) {
                    arr[i++] = j;
                    n--;
                }
                i += tmp;
            }
            
            if (arr[0] == 0) {
                boolean flag = true;
                for (int i = 1; i < arr.length; ++i) {
                    if (arr[i] != 0 && flag) {
                        arr[0] = arr[i];
                        arr[i] = 0;
                        flag = false;
                    }
                }
            }
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i]);
            }
        }
    }
}