import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
                int n = sc.nextInt();

            Map<String,Integer> map = new HashMap<>();
            while (n > 0) {
                map.put(sc.nextLine(),sc.nextInt());
                Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
            }
            List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
                public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            for (Map.Entry s : list) {
                System.out.println(s.getKey()+""+s.getValue());
            } 
        }
    }
}