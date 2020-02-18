package cn.itDemo;

import java.util.Scanner;

/**
 * 验证管理员登录 
 */
public class VerifyEqual {

	public VerifyEqual() {
	}

	public boolean verify(String s, String s1) {
		System.out.print("请输入用户名：");
		Scanner scanner = new Scanner(System.in);
		String s2 = scanner.next();
		System.out.print("请输入密码：");
		scanner = new Scanner(System.in);
		String s3 = scanner.next();
		return s2.equals(s) && s1.equals(s3);
	}
}