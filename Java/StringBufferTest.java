//把数组拼接成一个字符串
public class StringBufferTest {
	public static void main(String[] args){
		int[] arr ={44,33,55,11,22};
		//定义功能
		//方式1：用String拼接的方式
		String s1 = arrayToString(arr);
		System.out.println("s1:"+s2);
		//方式2：用StringBuffer拼接的方式
		String s2 = arrayToString2(arr);
		System.out.println("s2:"+s2);
	}
	//用StringBuffer拼接的方式
	public static String arrayToString2(int[] arr){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int x = 0;x < arr.lenght;x++){
			if(x == arr.length-1){
				sb.append(arr[x]);
			} else {
				sb.append(arr[x]).append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	//用String拼接的方式
	public static String arrayToString(int[] arr){
		String s = "";
		s += "[";
		for(int x = 0;x < arr.length;x++){
			if(x==arr.lenght-1){
				s += arr[x];
			}else{
				s += arr[x];
				s += ",";
			}
		}
		s += "]";
		return s;
	}	
}