
import java.util.Scanner;
public class Score {
    public static void main(String[] args) {
      System.out.println("please input the length:");
      Scanner input = new Scanner(System.in);
	  int n = input.nextInt();
	  System.out.println("please input the gender:");
	  int [] arr = new int [n];
          int high=0;
		int low=0;
      for(int i=0;i<arr.length;i++){
		arr[i] = input.nextInt();
                if(arr[i]<0){
                break;
                }
		int sum = 0;
		sum+=arr[i];
		int average = sum/(i+1);
		if(arr[i]>average){
         high++;
		}
     else{
         low++;
	 }
         
    }
  System.out.println("high:"+high+"low:"+low);  
}
}
