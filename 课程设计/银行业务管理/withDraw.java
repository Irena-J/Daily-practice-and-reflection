//5.取款类

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import keshe.Lianjie;
import test.quzhi;

public class withDraw {
      private Connection dbConn = Lianjie.getSQL();
      private PreparedStatement ps = null;
      private PreparedStatement pd = null;
      private ResultSet re = null;
      public withDraw() {

      }
      try {
            //        System.out.println(str);
            pd = dbConn.prepareStatement("Select money from Bank_User WHERE userName = ?");
            pd.setObject(1, quzhi.ch2);
            re = pd.executeQuery();
            while(re.next())
            {
                quzhi.ch7 = re.getString(1);
            }
            pd.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            if((Integer.parseInt(quzhi.ch7)) >= (Integer.parseInt(this.withdraw.getText())))
            {
                ps = dbConn.prepareStatement("Update Bank_User set money=money-? WHERE cardpasswd = ?" );
                ps.setObject(1,str);
                ps.setObject(2,quzhi.ch);
                int row = ps.executeUpdate();
                if(row > 0){
                System.out.println("修改数据成功");
            }
                this.dispose();
                tip.setVisible(true);
                
            }
            else
            {
                FailTip ft = new FailTip();
                this.dispose();
                ft.setVisible(true);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.print("修改数据失败!");
            
        }
        try {
            dbConn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}