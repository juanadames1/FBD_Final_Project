
package connectcionDb;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

//Hace conexion con la base de datos

public class Connector {
    String url = "jdbc:mysql://localhost:3306/world"; 
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    public Connection con;
    public ResultSet rs;
    public Statement stmt;
    public PreparedStatement pst;
    public Connector() {
    }
    
    public Connection connect(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Conexión denegada");
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void  disconnect(){
        try {
            con.close();
            System.out.println("Desconectado");
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
