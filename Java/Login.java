public void login(){
	String username = admin;
	String password = admin;
	for(int i = 0;i<3;i++){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		Scanner name = sc.nextLine();
		System.out.println("请输入密码");
		Scanner psw = sc.nextLine();
		
		if(name.equals(username)&&psw.equals(password)){
			System.out.println("登陆成功！");
			break;
		} else{
			if((2-i)==0){
				System.out.println("账户冻结");
			}else{
				System.out.println("输入错误，你还有"+(2-i)+"次机会");
			}
		}
	}
}