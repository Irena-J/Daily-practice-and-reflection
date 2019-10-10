import java.util.Scanner;
public class IsPrime{
	public static void main(String[] args){
		System.out.println("please input a number:")
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int i=2;
		for(;i<=sqrt((double)num);i++){
			if(num%i==0){
				break;
			}
		}if(i>sqrt((double)num)){
			System.out.println(num);
		}
	}
}