//1. 用户类
public class Account { 
    public String userorder;
    public String name,userName,password,cardnum,cardpasswd,money;
    public Account(){
        
    }
    public Account(String money){
        this.money=money;
    }
    public Account(String cardnum,String money){
        this.cardnum=cardnum;
        this.money=money;
    }
    public Account(String name,String userName,String password,String cardnum,String cardpasswd,String money){
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.cardnum=cardnum;
        this.cardpasswd=cardpasswd;
        this.money=money;
    }
     public Account(String userorder, String name,String userName,String password,String cardnum,String cardpasswd,String money){
        this.userorder=userorder;
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.cardnum=cardnum;
        this.cardpasswd=cardpasswd;
        this.money=money;
    }

    public String getUserorder() {
        return userorder;
    }

    public void setUserorder(String userorder) {
        this.userorder = userorder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getCardpasswd() {
        return cardpasswd;
    }

    public void setCardpasswd(String cardpasswd) {
        this.cardpasswd = cardpasswd;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    
}




                                 









