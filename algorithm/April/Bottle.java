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