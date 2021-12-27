package view;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.ArrayList;
 import java.util.List;

public class MailListReaderDB {
     private static Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         return conn;
     }

     public static List<String> read() {
         ArrayList<String> list = new ArrayList<>();
         String sql = "SELECT * FROM EMAIL";

        try (Connection conn = MailListReaderDB.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(rs.getString("direccion"));
            }
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
         return list;
     }
}
