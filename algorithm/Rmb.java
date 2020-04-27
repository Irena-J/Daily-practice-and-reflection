hasNext 是检查是否有非空字符
hasNextLine 检查输入中是否还有linePattern; LinePattern是一个正则表达式

static final String LINE_SEPARATOR_PATTERN = "\r\n|[\n\r\u2028\u2029\u0085]";
static final String LIKE_PATTERN = ".*("+LINE_SEPARATOR_PATTERN+")|.+$";

eg: 2 3 4 5
当处理完 5 后，没有非空字符了，hasNext返回了false，但是在linux系统中，5后面还有一个换行符\n,
0X0A，所以hasNextLine会返回true，但是其实后面并灭有可读元素了，所以sc.nextInt会抛出异常

hasNext检查是否有更多空白字符可用，hasNextLine检查是否有另一行文本可用。您的文本文件结尾可能有一个换行符，所以它有另一行，
但没有其他空白字符。

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext) {
			String str = sc.nextLine();
			String[] arr = str.split("\\.");
			String s = arr[0];
			StringBuilder sb = new StringBuilder("人民币");
			for (int j = 0,i = s.length(); i >= 0; i--,j++) {
				if (s.charAt(j) != '0') {
					if (j >= 3 && i % 4 == 0 && s.charAt(j-1) == '0' && s.charAt(j-2) == '0') {
						sb.append("零");
					}
					if (s.charAt(j) == '1' && i % 4 - 1 == 0) {
						
					} else {
						sb.append(Num(s.charAt(j));
					}
				}
				if (i != 0) {
					if (i % 8 == 0 && i >= 8) {
						sb.append("亿");
					}
					if (i % 4 == 0 && i % 8 != 0) {
						sb.append("万");
					}
					if (i % 4 - 3 == 0 && s.charAt(j) != '0') {
						sb.append("仟");
						if (s.chaAt(j+1) == '0' && s.charAt(j+2) != '0') {
							sb.append("零");
						}
					}
					if (i % 4 - 1 == 0 && s.charAt(j) != '0') {
						sb.append("拾");
					}
				}
			}
			if (s.charAt(0) != '0') {
				sb.append("元");
			}
			if (arr[1].equals("00")) {
				sb.append("整");
			} else {
				if (arr[1].charAt(0)=='0'){
					sb.append(arr(arr[1].charAt(1)));
					sb.append("分");
				}
				if (arr[1].charAt(1)=='0'){
					sb.append(Num(arr[1].charAt(0)));
					sb.append("角");
				}
				if (arr[1].charAt(0)!='0'&& arr[1].charAt(1)!='0'){
					sb.append(Num(arr[1].charAt(0)));
					sb.append("角");
					sb.append(Num(arr[1].charAt(1)));
					sb.append("分");
				}
			}
			System.out.println(sb);
			}
		}
		public static String Num(char c){
			if (c=='1'){
				return "壹";
			}if (c=='2'){
				return "贰";
			}if (c=='3'){
				return "叁";
			}if (c=='4'){
				return "肆";
			}if (c=='5'){
				return "伍";
			}if (c=='6'){
				return "陆";
			}if (c=='7'){
				return "柒";
			}if (c=='8'){
				return "捌";
			}if (c=='9'){
				return "玖";
			}
			return null;
		}
	}
 
    
