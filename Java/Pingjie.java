import java.util.*;
public class Pingjie {
    
    public static String func(String str) {
        String[] strs = str.split(" ");
        String ret = "";
        for(String s : strs) {
            ret += s;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();//abc def
        String ret = func(str);
        System.out.println(ret);
    }
}
