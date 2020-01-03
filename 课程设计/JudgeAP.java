//3.验证密码类

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import keshe.Lianjie;
import test.JudgeAP;
import test.quzhi;

public class JudgeAP{
    Connection conn = Lianjie.getSQL();
    private PreparedStatement ps = null;
    private ResultSet re = null;
    private String account, password;

    public JudgeAP() {
    }
    
    public JudgeAP(String password){
        this.password = password;
    }
    public JudgeAP(String account, String password){
        this.account = account;
        this.password = password;
    }
     public boolean getTest_Money()
     {
         boolean boo = false;
         try {
             ps = conn.prepareStatement("SELECT money FROM Bank_User WHERE userName = ?");
             ps.setString(1, account);
             re = ps.executeQuery();
             boo = re.next();
             
             
         } catch (SQLException ex) {
             ex.printStackTrace();
             System.out.println("SQL语句错误");
         }
//         System.out.println(boo);
         return boo;
     } 
    public boolean getTest_cardPwd()
     {
         boolean boo = false;
         try {
             ps = conn.prepareStatement("SELECT cardpasswd FROM Bank_User WHERE cardpasswd = ?");
             ps.setString(1, password);
             re = ps.executeQuery();
             boo = re.next();
             
             
         } catch (SQLException ex) {
             ex.printStackTrace();
             System.out.println("SQL语句错误");
         }
//         System.out.println(boo);
         return boo;
     }
     
     public boolean getTest_account()
     {
         boolean boo = false;
         try {
             ps = conn.prepareStatement("SELECT userName FROM Bank_User WHERE userName = ?");
             ps.setString(1, account);
             re = ps.executeQuery();
             boo = re.next();
             
             
         } catch (SQLException ex) {
             ex.printStackTrace();
             System.out.println("SQL语句错误");
         }
//         System.out.println(boo);
         return boo;
     }
     public boolean getTest_password()
     {
         boolean boo = false;
         if(getTest_account())
         {
             try {
                 ps = conn.prepareStatement("SELECT password FROM Bank_User WHERE userName = ? AND password = ?");
                 ps.setString(1, account);
                 ps.setString(2, password);
                 re = ps.executeQuery();
                 boo = re.next();
                 
             } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL语句错误");     
            }
           return boo;
        }
         else
             return false;
     }
     public void close()
     {
         Lianjie.close(conn);
     }
}
public class Judge {
    private Connection dbConn = Lianjie.getSQL();
    private PreparedStatement ps = null;
    private ResultSet re = null;
 

        quzhi.ch2 = this.userName.getText();
        JudgeAP b = new JudgeAP(this.userName.getText(),this.password.getText());
        Connection conn = Lianjie.getSQL();
        try {
            ps = conn.prepareStatement("SELECT cardnum FROM Bank_User WHERE userName = ? ");
            ps.setObject(1, this.userName.getText());
            re = ps.executeQuery();
            while(re.next())
            {
                quzhi.ch4 = re.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(b.getTest_password()){
           testa a = new testa();
           a.setUsername(this.userName.getText());
           this.dispose(); 
           a.setVisible(true);
        }
        else{
            EnterError c = new EnterError();
            this.dispose();
            c.setVisible(true);
        } 
    }     