class Practise{
	public Practise(){
		
	}
	public void Sweap(){
		int a=10;
		int b=20;
		int temp=0;
		temp=a;
		a=b;
		b=temp;
		System.out.println("a is :"+a+"   b is :"+b);
	}
	public void Max(){
		int a=1;
		int b=2;
		int c=-1;
		int max=(a>b?a:b)>c?(a>b?a:b):c;
		int min=(a<b?a:b)<c?(a<b?a:b):c;
		System.out.println("the max is :"+max +"   the min is :"+min);
	}
}


public class Test_1{
	public static void main(String[] args){
		Practise Pr = new Practise();
		Pr.Sweap();
		Pr.Max();
	}
}