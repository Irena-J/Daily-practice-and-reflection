import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] str = sc.nextLine().toCharArray();
            int[] a = new int[26];
            for(int i=0;i<str.length;i++){
                if(str[i]-'A' < 26 && str[i]-'A' >= 0){
                    a[str[i]-'A']++;
                }
            }
            for(int i=0;i<26;i++){
                System.out.println((char)(i+'A')+":"+a[i]);
            }
        }
    }
}