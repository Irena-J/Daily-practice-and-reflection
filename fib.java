//斐波那契递归实现
public int fib(int n){
	if(n == 1 || n == 2){
		return 1;
	}
	return fib(n-1)+fib(n-2);
}
//循环实现
public int fib(int n){
	int last2 = 1；
	int last1 = 1;
	int cur = 0;
	for(int i =3;i <= n;i++){
		cur =  last1 + last2;
		last2 = last1;
		last1 = cur;
	}
	return cur;
}