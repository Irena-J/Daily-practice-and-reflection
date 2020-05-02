import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.length() > 8 && isMoreThree(str) && isLong(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
    
    public static boolean isMoreThree(String str) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                a = 1;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                b = 1;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                c = 1;
            } else {
                d = 1;
            }
            if ((a+b+c+d) >= 3) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isLong(String str) {
        for (int i = 0; i < str.length()-2; i++) {
            if (str.substring(i+1).contains(str.substring(i,i+3))) {
                return false;
            }
        }
        return true;
    }
}