public class Test{
	public static void main(String[] args){
		System.out.println(findNum(15));
		public int findNum(int num){
			int count =0;
			while(num){
				count++
				num=num&(num-1);
			}
			return count;
		}
	}
}