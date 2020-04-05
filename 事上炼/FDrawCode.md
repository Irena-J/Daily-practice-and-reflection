```

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num3 = sc.nextInt();
        int num2 = sc.nextInt();
        int num4 = sc.nextInt();
        
        int A = (num1 + num2) >> 1;
        int B = (num3 + num4) >> 1;
        int C = (num4 - num3) >> 1;
        
        if (((A-B) == num1) && ((A+B) == num2)) {
            if (((B-C) == num3) && ((B+C) == num4)) {
                System.out.println(A+" "+B+" "+C+" ");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }
}
```

