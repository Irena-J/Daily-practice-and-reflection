public static void createBases(){
    Connection connection = null;
    Statement stmt = null;
        try {
        //加载数据库驱动,利用的是反射机制
        Class.forName("com.mysql.jdbc.Driver");//这个路径固定
        //获取一个连接
        connection = DriverManager.getConnection("jdbc:mysql://localhost","root","");
        stmt = connection.createStatement();
        stmt.execute("create database learn_1230");
        //stmt.execute("drop database my_jdbc_db");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        finally {

        try {
            if(stmt != null){
                stmt.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}