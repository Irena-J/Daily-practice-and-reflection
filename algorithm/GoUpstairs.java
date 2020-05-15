import java.util.*;

public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for(int i=3;i<=n;i++){
            int temp = ((a+b)%1000000007+c)%1000000007;
            a = b;
            b = c;
            c = temp; 
        }
        return c;
    }
}