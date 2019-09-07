public class Account{
	privata int id;
	privata double balance;
	privata double annuaInterestRate;
	pivata java.util.Date dateCreated = new java.util.Date();
	public Account(){
		this.id = 0;
		this.balance =0;
		this.annuaInterestRate = 0;
	}
	public Account(int id,int balance){
		this.id = id;
		this.banlance = banlance;
		public int getId(){
			return this.id;
		}
		public void setId(){
			this.id=id;
		}
		public double getBalance(){
			return this.getBalance;
		}
		public void setBalance(){
			this.banlance=balance;
		}
		public double getAnnuaInterestRate();{
			return annuaInterestRate;
		}
		public void setAnnuaInterestRate(){
			this.annuaInterestRate=annuaInterestRate;
		}
		public double getMonthlyInterestRate(){
			this.annuaInterestRate/12;
		}
		public double withDraw(double money){
			this.balance = balance-money;
			return this.balance;
		}
		public double deposit(double money){
			this.banlance = banlance+money;
			return this.balance;
		}
		public java.util.Date getDateCreated(){
			return this.DateCreated;
		}
	}
	 
}
public class TestAccount{
	public class static void main(String[] args){
		Account sb = new Account(1122,20000);
		sb.annuaInterestRate(0.045);
		sb.withDraw(2500)
		sb.deposit(3000)
		System.out.println("余额："+sb.balance()+"月利率:"+sb.annuaInterestRate()+"开户日期:"+sb.DateCreated());id
	}
}