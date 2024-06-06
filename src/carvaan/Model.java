
package carvaan;

import carvaan.Entity.Admin;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Model {
    public static void main(String args[]) {
        try {
//            String driverClassName= "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digigarage","root","sa123");
            String query = "select * from admin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getString(1) +" " + rs.getString(2));
            }
            else{
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean authenticate(Admin admin) throws SQLException, ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digigarage","root","sa123");
        
        String query = "select * from admin where username = '" + admin.getUserName() + "' and password = '" + admin.getPassWord()+"'";
        System.out.println("carvaan.Model.authenticate()" + admin);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs.next();
    }
    
}
