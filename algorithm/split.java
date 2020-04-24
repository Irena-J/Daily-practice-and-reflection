import java.util.Scanner;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> hs = new HashSet<String>();
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			for (int i = 0; i < str.length; i++) {
				hs.add(arr[i]);
			}
		}
		System.out.println(hs.size());
	}
}