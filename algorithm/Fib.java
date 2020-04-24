import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int f1 = 0;
		int f2 = 1;
		int f3 = 1;
		
		while (f3 < N) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		int step = (f3-N) > (N-f1) ? N-f1 : f3-N;
		System.out.println(step);
	}
}