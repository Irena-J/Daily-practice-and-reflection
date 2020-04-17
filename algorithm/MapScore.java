
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.merge(scanner.nextInt(),1,Integer::sum);
            }
            System.out.println(map.getOrDefault(scanner.nextInt(),0));
        }
    }
}


