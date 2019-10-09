import java.util.Scanner;
class Practise{
	public Practise(){	
	
	}
	public void printAge(int age){
		if(age>18){
			System.out.println("shaonian");
		}else if(age>18&&age<=28){
			System.out.println("qingnian");
		}else if(age>28&&age<=55){
			System.out.println("zhongnian");
		}else if(age>55){
			System.out.println("laonian");
		}else{
			System.out.println("!");
		}
	}
}
public class Test_2{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("please input age:");
		int age = input.nextInt();
		Practise Pr = new Practise();
		Pr.printAge(age);	
	}
}