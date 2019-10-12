import java.util.Scanner;
public class Equals{
	public static void main(String[] args){
		String password ="i do not know";
		int i=0;
		System.out.println("please input the password:");
		Scanner input = new Scanner(System.in);
		for(;i<3;i++){
			String Str = input.nextLine();
			if(Str.equals("i do not know")){
				System.out.println("you are right");
				break;
			}else{
				System.out.println("!!! input again");
			}
		}
		System.out.println("exit!!!");
	}
}
