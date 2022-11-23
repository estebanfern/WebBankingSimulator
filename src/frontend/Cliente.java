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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



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
                database.close();
                return true;
            }
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "Ingrese una cuenta valida");
        }
    database.close();
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
        stmt.close();
        rs.close();
        database.close();
        return arr;
    }
    
    public static int getSaldo(int user) throws SQLException{
        Connection database = conectar();
        String selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int saldo = rs.getInt("saldo");
        stmt.close();
        rs.close();
        database.close();
        return saldo;
    }
    
    public static void deposito(int user, int monto, int tipo, int nroCheque) throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String fecha = dtf.format(now);
        Connection database = conectar();
        String selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int saldo = rs.getInt("saldo") + monto;
        stmt.close();
        
        //Se crea una transaccion
        stmt = database.createStatement();
        String query = "INSERT INTO transacciones (cuenta_id,tipo,fecha,monto) VALUES('"+ user+ "',"+String.valueOf(0)+",'"+ fecha +"',"+String.valueOf(monto)+")";
        stmt.executeUpdate(query);
        stmt.close();

        //Se obtiene el ultimo id
        stmt = database.createStatement();
        query = "SELECT MAX(transaccion_id) AS transaccion_id  FROM transacciones";
        rs = stmt.executeQuery(query);
        int transaccion_id = rs.getInt("transaccion_id"); // Valor del ultimo ID 
        stmt.close();

        //Se cargan los detalles en la tabla deposito
        stmt = database.createStatement();
        query = "INSERT INTO depositos (deposito_id,tipo,numero_cheque) VALUES("+ String.valueOf(transaccion_id) + "," + String.valueOf(0) + "," + String.valueOf(0) +")";
        stmt.executeUpdate(query);
        stmt.close();
        
        //Se actualiza el saldo en la DB
        stmt = database.createStatement();
        selectSql = "UPDATE cuentas SET saldo = '" + String.valueOf(saldo) + "' WHERE numero_cuenta = '" + user + "'";
        stmt.executeUpdate(selectSql);
        stmt.close();
        rs.close();
        
        stmt = database.createStatement();
        
        
        database.close();
     
    }
    
    public static void transferir(int userOrigen, int userDestino, int monto) throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String fecha = dtf.format(now);

        //Se le suma al destino
        Connection database = conectar();
        String selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + userDestino + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int saldo = rs.getInt("saldo") + monto;
        stmt.close();

        //Se actualiza el saldo en la DB
        stmt = database.createStatement();
        selectSql = "UPDATE cuentas SET saldo = '" + String.valueOf(saldo) + "' WHERE numero_cuenta = '" + userDestino + "'";
        stmt.executeUpdate(selectSql);
        stmt.close();
        rs.close();

        //Se le suma al destino
        selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + userOrigen + "'";
        stmt = database.createStatement();
        rs = stmt.executeQuery(selectSql);
        saldo = rs.getInt("saldo") - monto;
        stmt.close();

        //Se actualiza el saldo en la DB
        stmt = database.createStatement();
        selectSql = "UPDATE cuentas SET saldo = '" + String.valueOf(saldo) + "' WHERE numero_cuenta = '" + userOrigen + "'";
        stmt.executeUpdate(selectSql);
        stmt.close();
        rs.close();





    }
    
    
    public static void main(String [] args){
        try{
            transferir(1, 2, 6000000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
