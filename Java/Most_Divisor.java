//1. isPrime()
// // // // // // import java.util.Scanner;
// import java.util.Random;
// public class Prictise_2{
	// public static void main(String[] args){
		// System.out.println("please input a num:")
		// Scanner input = new Scanner(System.in)
		// int num = input.nextInt();
		// Random random = new Random();
		// int guess = random.nextInt(100);
		
		
	// }
// }

// import java.util.Scanner;
// import java.util.Random;
// public class Prictise_2{
	// public static void main(String[] args){
		// System.out.println("please input a num:")
		// Scanner input = new Scanner(System.in)
		// int num = input.nextInt();
		// Random random = new Random();
		// int guess = random.nextInt(100);
		
		
	// }
// }




//2.print prime

// public class Prictise_2{
	// public static void main(String[] args){
		// for(int i=2;i<=100;i++){
			// boolean flag = true;
			// for(int j=2;j<i;j++){
				// if(i%j==0){
					// flag=false;
					// break;
				// }
			// }
			// if(flag){
			// System.out.println(i);
			// }
		// }
	
	// }
// }

//3.1穷举(从其中一个较小的数开始依次直到找到公约数位置，边界条件就是1到那个较小的数)
import java.util.Scanner;
public class Prictise_2{
	public static void main(String[] args){
		System.out.println("please input two numbers:");
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num = num1<num2?num1:num2;
		int i=0;
		for(i=num;i>0&&((num1%i!=0)||(num2%i!=0));i--){
			
		}		
		System.out.println(i);
	}
}











