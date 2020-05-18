import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
        String st = str.substring(2);
        int n = 0;
        int num = 0;
        for (int i = 0; i < st.length(); i++){
            switch(st.charAt(i)){
                case 'A' : n = 10; break;
                case 'B' : n = 11; break;
                case 'C' : n = 12; break;
                case 'D' : n = 13; break;
                case 'E' : n = 14; break;
                case 'F' : n = 15; break;
                default : n = st.charAt(i) - '0';
            }
            num = num + n * (int)Math.pow(16, st.length()- 1 - i);
        }
        System.out.println(num);
        }
    }
}




