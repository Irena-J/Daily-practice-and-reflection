equals() 方法的源码分析

public boolean equals(Object anObject) {
	// 对象引用相同直接返回 true
	if (this == anObject) {
		return true;
	}
	// 判断需要对比的值是否为 String 类型，如果不是则返回 false
	if (anObject instanceof String) {
		String anotherString = (String)anObject;
		int n = value.length;
		if (n == anotherString.value.length) {
			// 把两个字符串都转换为 char 数组对比
			char v1[] = value;
			char v2[] = anotherString.value;
			int i = 0;
			// 循环对比两个字符串的每一个字符
			while (n-- != 0) {
				// 如果其中有一个字符不相等就 false，否则继续对比
				if (v1[i] != v2[i])
					return false;
				i++;
			}
			return true;
		}
	}
	return false;
}