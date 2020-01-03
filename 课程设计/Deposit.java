//4.存款类

public class Deposit{

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import keshe.Lianjie;

        public Deposit() {

        }

        private Connection dbConn = Lianjie.getSQL();
        private PreparedStatement ps = null;

        pu
        try {
            ps = dbConn.prepareStatement("Update Bank_User set money=money+? WHERE cardpasswd = ?" );
            ps.setObject(1,str);
            ps.setObject(2,quzhi.ch);
            int row = ps.executeUpdate();
            if(row > 0){
              System.out.println("修改数据成功");
            }
            this.dispose();
            tip.setVisible(true);
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