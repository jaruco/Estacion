package conexion;

import java.security.MessageDigest;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jruiz
 */
public class Conexion {

    public static Connection con;
    private static Conexion INSTANCE = null;
    private final int logginCorrecto = 1;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private static final char[] CONSTS_HEX = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public Conexion() {
        performConnection();
    }
 
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Conexion();
        }
    }
 
    public static Conexion getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
 
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
    public void performConnection() {  
        String url = "jdbc:sqlserver://localhost:1433; databaseName=siesve; user=sa; password=login";
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              	con= DriverManager.getConnection(url);
//                System.out.println("Conexion Exitosa");                
            }
            catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            } 
    }
    public int login(String usuario, String contrasenia){
            try{
                String user = "";
                int idGrupo = 0;
                String query = "select usuario, idGrupo from Usuario where usuario='"+usuario+"' and password='"+contrasenia+"' ;";
                stm = con.createStatement();
                rs = stm.executeQuery(query);
                while (rs.next()) {                  
                    user = rs.getString(1);
                    idGrupo = rs.getInt(2);
                }
                if(idGrupo != 0)
                {
                    return logginCorrecto;
                }                
            }
            catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        return 0;
    }
 
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
       
    public CallableStatement setCST(String sql) throws SQLException{
        CallableStatement cst = con.prepareCall(sql);
        return cst;
    }
    
    public Connection getConnection(){
      return con;
   }       
       
    public static String encriptaEnMD5(String stringAEncriptar)
    {
        try
        {
           MessageDigest msgd = MessageDigest.getInstance("MD5");
           byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
           StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
           for (int i = 0; i < bytes.length; i++)
           {
               int bajo = (int)(bytes[i] & 0x0f);
               int alto = (int)((bytes[i] & 0xf0) >> 4);
               strbCadenaMD5.append(CONSTS_HEX[alto]);
               strbCadenaMD5.append(CONSTS_HEX[bajo]);
           }
           return strbCadenaMD5.toString();
        } catch (Exception e) {
           return null;
        }
    }   
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
}  