import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int flag = 0;
            int i = 0, j = str.length() - 1;
            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    if (i + 1 <= j && str.charAt(i + 1) == str.charAt(j)) {
                        i++;
                        flag++;
                    } else if (j - 1 >= i && str.charAt(i) == str.charAt(j - 1)) {
                        j--;
                        flag++;
                    } else {
                        flag+=2;
                        break;
                    }
                } else {
                    i++;
                    j--;
                }
            }
            if (flag < 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


