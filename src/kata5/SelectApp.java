package kata5;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class SelectApp {
    private Connection connect() {
        String url = "jdbc:sqlite:Prueba.db"; 
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
            
        }
            return conn;
        }
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)){
        while (rs.next()) { 
            System.out.println(rs.getInt("id") + "\t" +
                               rs.getString("Nombre") + "\t" + 
                               rs.getString("Apellido") + "\t" + 
                               rs.getString("Departamento") + "\t");
        }
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        } 
    }
}
