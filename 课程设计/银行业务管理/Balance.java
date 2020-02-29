//2.查询余额类
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import keshe.Lianjie;
import 数据库.Account;

public class Balance {
    private Connection dbConn = Lianjie.getSQL();
    private PreparedStatement ps = null;
    private ResultSet re = null;
    private ArrayList<Account> list =new ArrayList<>();
    public Balance() {
    }
    public ArrayList<Account> getData()
    {
         try {
             ps = dbConn.prepareStatement("SELECT cardnum,money FROM Bank_User WHERE userName=?");
             ps.setObject(1,quzhi.ch2);
             re = ps.executeQuery();
             while(re.next())
             {
                 Account ti = new Account(re.getString(1),re.getString(2));
                 list.add(ti);
             }
             return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(Balance.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
    public void close(){
        Lianjie.close(dbConn);
    }

}