
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
    private static Connection c = null;
    private ConnectionFactory(){}  
    private static String url= "jdbc:mysql://localhost/thiamaco";
    private static String user="thiamaco";
    private static String pass="thiamaco";

public static Connection getConnection() throws SQLException {
        if(c==null){
            c= DriverManager.getConnection(url,user,pass);
        }else{
            if(c.isClosed()){
                c= DriverManager.getConnection(url,user,pass);
            }
        }
        return c;
    }
    
/* 
    private static final String JDBC_URL = "jdbc:mysql://localhost/thiamaco";
    private static final String JDBC_USER = "thiamaco";
    private static final String JDBC_PASSWORD = "thiamaco";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }
*/
}
