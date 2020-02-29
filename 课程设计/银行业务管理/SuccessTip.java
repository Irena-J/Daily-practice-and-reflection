import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import keshe.Lianjie; 
import test.quzhi;


public class SuccessTip{


        private Connection dbConn = Lianjie.getSQL();
        private PreparedStatement ps = null;
        public SuccessTip() {
         }
        try {
                String str = "存入" + quzhi.ch3 + "元";
                ps = dbConn.prepareStatement("Insert INTO business_list(time,cardnum,operation) VALUES(getdate(),?,?)" );
                ps.setObject(1,quzhi.ch4);
                ps.setObject(2,str);
                int row = ps.executeUpdate();
                if(row > 0){
                    System.out.println("修改数据成功");
                }
                ps.close();
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