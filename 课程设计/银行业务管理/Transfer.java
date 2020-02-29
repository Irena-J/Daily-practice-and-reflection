//6.转账类

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import keshe.Lianjie;
import test.quzhi;
public class Transfer{

    private Connection dbConn = Lianjie.getSQL();
    private PreparedStatement ps = null;
    private PreparedStatement pd = null;
    public Transfer() {
        initComponents();
    }
     try {
            //        System.out.println(str);
            ps = dbConn.prepareStatement("Update Bank_User set money=money+?  WHERE userName = ?" );
            ps.setObject(1,str);
            ps.setObject(2,this.username.getText());
            
            pd = dbConn.prepareStatement("Update Bank_User set money=money-?  WHERE userName = ?" );
            pd.setObject(1,str);
            pd.setObject(2,quzhi.ch2);
            //ps.setObject(2,pwd.getPwd());
            int row = ps.executeUpdate();
            int row2 = pd.executeUpdate();
            if(row > 0 && row2 >0){
              System.out.println("修改数据成功");
            }
            ps.close();
            pd.close();
            SuccessTip3 tip = new SuccessTip3();
            this.dispose();
            tip.setVisible(true);
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