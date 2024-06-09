
package Digigarage;

import Digigarage.Entity.Accessory;
import Digigarage.Entity.Admin;
import Digigarage.Entity.Customer;
import static java.lang.Math.max;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Model {
    
    static Connection con;
    static int maxID = 0;
    
    private static void connection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digigarage","root","sa123");
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        try {
//            String driverClassName= "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digigarage","root","sa123");
            String query = "select * from admin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getString(1) +" " + rs.getString(2));
            }
            else{
                
            }
            con.close();
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
        con.close();
        return rs.next();
    }
    
    public static ArrayList<Accessory> getInventory() throws SQLException{
        connection();
        ArrayList<Accessory> obj = new ArrayList<>();
        
        String query = "select * from Accessories";
        System.out.println("carvaan.Model.getInventory()");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            int stock = rs.getInt(3);
            int price = rs.getInt(4);
            
            obj.add(new Accessory(id, name, stock, price));
            maxID = max(maxID,Integer.parseInt(id));
        }
//        rs.last();
//        maxID = Integer.parseInt(rs.getString(1));
        con.close();
        
        return obj;
    }  
    
    public static void addAccessory(Accessory obj) throws SQLException{
        connection();
        PreparedStatement stmt=con.prepareStatement("insert into Accessories values(?,?,?,?)");
        stmt.setString(1, String.valueOf(++maxID));
        stmt.setString(2, obj.getName());
        stmt.setInt(3, obj.getStock());
        stmt.setInt(4, obj.getPrice());
        
        stmt.execute();
        con.close();
        
    }
    
    public static int getMaxId(){
        return maxID;
    }
    
    public static ArrayList<Customer> getCustomers() throws SQLException{
        connection();
        Customer c;
        ArrayList<Customer> res = new ArrayList<>();
        String query = "select * from Customer";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            c = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
            res.add(c);
        }

        return res;
    }
    
}
