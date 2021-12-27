package kata5;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

public class Kata5_2 {

    public static void main(String[] args) {
        //connect();
        SelectApp app = new SelectApp(); 
        app.selectAll();
        
        CrearDB nuevaDb = new CrearDB();
        nuevaDb.createNewDatabase("mail.db");
    }
   
    private static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:Prueba.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
            
        } catch (SQLException e) { 
            System.out.println("ERROR: SQLEXCEPTION " + e.getMessage());
            
        } finally {
            try { 
                if (conn != null) {
                    conn.close();
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: SQLEXCEPTION " + ex.getMessage()); 
            }
        }
    }
}
