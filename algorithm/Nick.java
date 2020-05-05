import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            StringBuffer sb = new StringBuffer();
            int a = n * (n - 1) + 1;
            System.out.print(a);
            for (int i = 1; i < n; ++i) {
                System.out.print("+"+(a+=2));
            }
            System.out.println();
        }
    }
}