import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt) {
            int T = sc.hasNext();
            for (int i = 0; i < T; i++) {
                int n = sc.hasNext();
                int k = sc.hasNext();
                int[] arr = new int[2*n];
                for (int j = 0; j < 2n; j++) {
                    arr[j] = sc.nextInt();
                }
            }
            LinkedList<Integer> li = new LinkedList<Integer>();
			for (int i = 0; i < 2n; i++) {
				while ((k--)>0) {
					while (end > (2n-1)>>1 || mid >= 0) {
						int end = 2n-1;
						int mid = (2n-1)>>1;
						if (end > (2n-1)>>1) {
							li.push(arr[end]);
						}
						if (mid >= 0) {
							li.push(arr[mid]);
						}
					}
					while (!li.isEmpty()) {
						if (k == 1) {
							System.out.println(li.pop())
						} else {
							li.pop();
						}
					}
				}
			}
		}
	}
}
