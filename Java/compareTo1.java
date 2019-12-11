//compareTo的底层实现
public int compareTo(String str2){
	int len1 = value.length;//当前要比较的字符串的长度
	int len2 = str2.value.length;
	int lim = Math.min(len1,len2);
	char[] v1 = value;
	char[] v2 = str2.value;
	
	int k = 0;
	while(k < lim) {//在这个长度范围内是否能找到那个大
		char c1 = v1[k];
		char c2 = v2[k];
		if(c1 != c2){
			return c1-c2;
		}
		k++;
	}
	return len1 - len2;
}
//多次拆分
String str = "name=zhangsan&age=19";
String[] result = str.split("&");
for(int i = 0;i<result.length;i++){
	String[] temp = result[i].split("=");
	System.out.println(temp[0]+"="+temp[1]);
}