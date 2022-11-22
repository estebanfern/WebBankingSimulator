/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.swing.JOptionPane;

/**
 *
 * @author esteb
 */
public class Cliente {
    
    public static Connection conectar(){
        Connection database = null;
        try{
            database = DriverManager.getConnection("jdbc:sqlite:data.db");
            return database;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al conectarse");
            return null;
        }
    }
    
    public static boolean validarLogin(int user, String pin) throws SQLException{
        Connection database = conectar();
        String selectSql = "SELECT pin FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        try{
            if (rs.getString("pin").equals(pin)){
                return true;
            }
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "Ingrese una cuenta valida");
        }
    return false;
    }
    
    public static String[] getInfo(int user) throws SQLException{
        Connection database = conectar();
        String selectSql = "SELECT * FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        String arr [] = new String [5];
        arr[0] = rs.getString("nombre");
        arr[1] = rs.getString("apellido");
        arr[2] = rs.getString("ci");
        arr[3] = rs.getString("email");
        arr[4] = rs.getString("celular");
        return arr;
    }
    
    
}
