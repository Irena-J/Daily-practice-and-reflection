import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int count = 1;
            int N = n;
            while (n > 0) {
                n /= 10;
                count *= 10;
            }
            n = N;
            N *= N;
            if (N % count == n) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
            /*
            int n = sc.nextInt();
            String str1 = String.valueOf(n);
            String str2 = String.valueOf(n*n);
            if (str2.endsWith(str1)) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
            */
        }
    }
}