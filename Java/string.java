//实现字符串的拆分，以空格
String str = "hello world !";
String[] ret = str.split(" ");//按照空格拆分
for(String s ： ret){
	System.out.println(s);
}

//字符串的不扽拆分
String str = "hello world";
String[] ret = str.split(" ",2);
for(String s : ret){
	System.out.println(s);
}
//拆分IP 注意要加转义字符
String str = "192.168.2.8";
String[] ret = str.split("\\.");
for(String s : ret){
	System.out.println(s);
}