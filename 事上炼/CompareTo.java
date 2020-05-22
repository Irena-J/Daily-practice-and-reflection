compareTo() 方法的源码分析

public int compareTo(String anotherString) {
	int len1 = value.legnth;
	int len2 = anotherString.value.legnth;
	// 获取到两个字符串长度最短的那个 int 值
	int lim = Math.min(len1,len2);
	char v1[] = value;
	char v2[] = anotherString.value;
	int k = 0;
	// 对比每一个字符
	while (k < lim) {
		char c1 = v1[k];
		char c2 = v2[k];
		if (c1 != c2) {
			// 有不相等就返回差值
			return c1 - c2;
		}
		k++;
	}
	return len1 - len2;
	
}





