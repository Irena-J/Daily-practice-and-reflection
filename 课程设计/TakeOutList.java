import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import keshe.Lianjie;
import 数据库.BusinessList;

public class TakeOutList {
    private Connection dbConn = Lianjie.getSQL();
    private PreparedStatement ps = null;
    private ResultSet re = null;
    private ArrayList<BusinessList> list4 =new ArrayList<>();
    public TakeOutList(){
        
    }
    public ArrayList<BusinessList> getData()
    {
         try {
             ps = dbConn.prepareStatement("SELECT time,cardnum,operation FROM business_list WHERE cardnum = ?");
             ps.setObject(1, quzhi.ch4);
             re = ps.executeQuery();
             while(re.next())
             {
                 BusinessList ti = new BusinessList(re.getString(1),re.getInt(2),re.getString(3));
                 list4.add(ti);
             }
             return list4;
             
         } catch (SQLException ex) {
             Logger.getLogger(TakeOutStaff.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
    public void close(){
        Lianjie.close(dbConn);
    }
}