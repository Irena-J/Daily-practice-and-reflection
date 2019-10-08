public class Factorial{
	public static void main(String[] args){
		int i=1;
		int sum=0;
		while(i<=5){
			int tem = 1;
			int ret = 1;
			while(tem<=i){
				ret*=tem;
				tem++;
			}
			sum+=ret;
			i++;
		}
		System.out.println(sum);
	}
}