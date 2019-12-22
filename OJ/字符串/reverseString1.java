方法一：
    public String reverseString(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while(i<j){
            swap(ch,i,j);
            i++;
            j--;
        }
        return new String(ch);
    }
    public void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
方法二：借用异或运算
  public void reverseString(char[] s) {
        for(int i = 0;i < s.length/2;i++){
            int j = s.length-i-1;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
	
方法三：
public static Strting reverseString(String s){
	StringBuffer sb = new StringBuffer();
	sb.append(s);
	
	StringBuffer sb = new StringBuffer(s);
	sb.reverse();
	return sb.toString();
	
	return new StringBuffer(s).reverse.toString();
	
方法四：
	public static String reverseString(String s){
		String result = "";
		char[] chs = s.toCharArray();
		for(int x = chs.length - 1; x >= 0; x--){
			result += chs[x];
		}
		return result;
	}
	//判断一个字符串是否回文，就是对称,方式1：
	public static boolean isSame(String s){
		char[] arr = s.toCharArray();
		boolean flag = true;
		for(int start = 0,end = arr.length-1;start <= end;start++,end--){
			if(arr[start]!=arr[end]){
				flag = false;
				break;
			}
		}
		return flag;
	}
	方式2;利用StringBuffer的反转功能
	public static boolean isSame2(String s){
		StringBuffer sb = new StringBuffer();
		sb.reverse(s).toString().equals(s);
	}
}


















