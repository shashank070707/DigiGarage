
package Digigarage;

import Digigarage.Entity.Accessory;
import Digigarage.Entity.Admin;
import Digigarage.Entity.Car;
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
        boolean res = rs.next();
        con.close();
        return res;
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
    
    public static void updateAccessory(Accessory obj) throws SQLException{
        connection();
        PreparedStatement stmt=con.prepareStatement("update Accessories set NAME = ?,STOCK = ?,PRICE = ? where ID = ?");
        stmt.setString(1, obj.getName());
        stmt.setInt(2, obj.getStock());
        stmt.setInt(3, obj.getPrice());
        stmt.setString(4, obj.getID());
        stmt.execute();
        con.close();
    }

    static ArrayList<Car> getCars() throws SQLException {
        connection();
        String query = "select REGISTRATION_NUMBER,MODEL,NAME,PHONE_NUMBER,DATE_OF_PURCHASE from car inner join customer on owner = PHONE_NUMBER";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Car> cars = new ArrayList<>();
        while(rs.next()){
            cars.add(new Car(rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(2),rs.getDate(5)));
        }
        return cars;
    }
    
    public static void addCustomer(Customer customer) throws SQLException{
        connection();
        PreparedStatement stmt=con.prepareStatement("insert into customer values(?,?,?)");
        stmt.setString(1, customer.getPhoneNumber());
        stmt.setString(2, customer.getName());
        stmt.setString(3, customer.getAddress());
        
        stmt.execute();
        con.close();
    }

    static String getOwnerName(String ownerContact) throws SQLException {
        connection();
        String query = "select NAME from customer where PHONE_NUMBER = '" + ownerContact + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            return rs.getString(1);
        }
        else{
            return null;
        }
        
    }

    static void addCar(Car car) throws SQLException {
        connection();
        PreparedStatement stmt=con.prepareStatement("insert into car values(?,?,?,?)");
        stmt.setString(1, car.getOwnerContact());
        stmt.setString(2, car.getRegistrationNumber());
        stmt.setString(3, car.getModel());
        stmt.setString(4, String.valueOf(car.getDateOfPurchase()));
        
        stmt.execute();
        con.close();
        
    }
   
}
