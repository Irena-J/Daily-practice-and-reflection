//对一个字符串进行排序
public class Sort{
	public static void main(String[] args){
		String str = "afdgsdh";
		char[] ch = str.toCharArray();
		//bubble(ch);
		//String ret = String.valueOf(ch);
		//System.out.println(ret);
	//}
	//public static void bubble(char[] ch){
		for(int i = 0;i < ch.length-1;i++){
			for(int j = 0;j <ch.length-1-i;i++){
				if(ch[j] > ch[j+1]){
					char temp = ch[j];
					ch[j] = ch[j+1];
					ch[j+1] = temp;
				}
			}
		}
		String ret = String.valueOf(ch);
		System.out.println(ret);
	}
}