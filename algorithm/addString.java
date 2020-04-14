import java.util.Scanner;
import java.util.HashSet;
import java.lang.StringBuilder;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            HashSet<Character> set = new HashSet<Character>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s2.length(); i++) {
                set.add(s2.charAt(i));
            }
            for (int i = 0; i < s1.length(); i++) {
                if (set.add(s1.charAt(i))) {
                    set.remove(s1.charAt(i));
                    sb.append(s1.charAt(i));
                }
            }
            System.out.print(sb);
        }
    }
}