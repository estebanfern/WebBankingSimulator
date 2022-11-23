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



import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        //Se crea una transaccion
        stmt = database.createStatement();
        String query = "INSERT INTO transacciones (cuenta_id,tipo,fecha,monto) VALUES('"+ userOrigen + "',"+
                                                    String.valueOf(1) + ",'" + fecha + "',"+ String.valueOf(-1*monto) + 
                                                    ")" + ";" + "INSERT INTO transacciones (cuenta_id,tipo,fecha,monto) VALUES('"+ userDestino + "',"+
                                                    String.valueOf(1) + ",'" + fecha + "',"+ String.valueOf(monto) + 
                                                    ")" ;
        stmt.executeUpdate(query);
        stmt.close();

        //Se obtiene el ultimo id
        stmt = database.createStatement();
        query = "SELECT MAX(transaccion_id) AS transaccion_id  FROM transacciones";
        rs = stmt.executeQuery(query);
        int transaccion_id = rs.getInt("transaccion_id"); // Valor del ultimo ID 
        stmt.close();

        //Se cargan los detalles en la tabla transferencias
        stmt = database.createStatement();
        query = "INSERT INTO transferencias (transferencia_id, id_origen, id_destino) VALUES("+ String.valueOf(transaccion_id-1) 
                + "," + String.valueOf(userOrigen) + "," + String.valueOf(userDestino) +")" + ";" + 
                "INSERT INTO transferencias (transferencia_id, id_origen, id_destino) VALUES("+ String.valueOf(transaccion_id) 
                + "," + String.valueOf(userOrigen) + "," + String.valueOf(userDestino) +")";
        stmt.executeUpdate(query);
        stmt.close();

        JOptionPane.showMessageDialog(null, "Ticket generado\nTransferencia entre Cuentas\nNro de cuenta origen: " + 
                                                                        "000" + userOrigen + "\nNro de cuenta destino: " 
                                                                        + "000" + userDestino + "\nFecha: " + fecha + "\nMonto: " + monto);

    }

    public static void servicio(int user, int monto, int tipo) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String fecha = dtf.format(now);

        //Se le resta el monto al saldo de la cuenta
        Connection database = conectar();
        String selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int saldo = rs.getInt("saldo") - monto;
        stmt.close();

        //Se actualiza el saldo en la DB
        stmt = database.createStatement();
        selectSql = "UPDATE cuentas SET saldo = '" + String.valueOf(saldo) + "' WHERE numero_cuenta = '" + user + "'";
        stmt.executeUpdate(selectSql);
        stmt.close();
        rs.close();

        //Se crea una transaccion
        stmt = database.createStatement();
        String query = "INSERT INTO transacciones (cuenta_id,tipo,fecha,monto) VALUES('"+ user+ "',"+String.valueOf(2)+",'"+ fecha +"',"+String.valueOf(-1*monto)+")";
        stmt.executeUpdate(query);
        stmt.close();

        //Se obtiene el ultimo id
        stmt = database.createStatement();
        query = "SELECT MAX(transaccion_id) AS transaccion_id  FROM transacciones";
        rs = stmt.executeQuery(query);
        int transaccion_id = rs.getInt("transaccion_id"); // Valor del ultimo ID 
        stmt.close();

        //Se cargan los detalles en la tabla servicios
        stmt = database.createStatement();
        query = "INSERT INTO servicios (servicio_id,numero_servicios) VALUES("+ String.valueOf(transaccion_id) + "," + String.valueOf(tipo) +")";
        stmt.executeUpdate(query);
        stmt.close();

        String [] servicios = {"ESSAP", "ANDE", "COPACO", "NETFLIX"};
        JOptionPane.showMessageDialog(null, "Ticket generado\nPago de Servicio\nNro de cuenta: " + 
                                                                "000" + user + "\nFecha: " + fecha + "\nMonto: " + monto + 
                                                                    "\nServicio: " + servicios[tipo]);

    }
    
    public static DefaultTableModel getTarjetas(int user, JTable tabla) throws SQLException{
        Connection database = conectar();
        String selectSql = "SELECT * FROM tarjetas WHERE cuenta_id = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        String[] arr = new String[3];
        String[] marcas = {"VISA", "MASTERCARD"};
        while (rs.next()){
            arr[0] = marcas[rs.getInt("tipo_tarjeta")];
            arr[1] = rs.getString("numero_tarjeta");
            arr[2] = rs.getString("fechaVencimiento");
            modelo.addRow(arr);
            impr(arr);
        }

        return modelo;
    }

    public static void pagoTc(int user, int monto, String nroTarjeta, int tipo) throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String fecha = dtf.format(now);

        //Se le resta el monto al saldo de la cuenta
        Connection database = conectar();
        String selectSql = "SELECT saldo FROM cuentas WHERE numero_cuenta = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int saldo = rs.getInt("saldo") - monto;
        stmt.close();

        //Se actualiza el saldo en la DB
        stmt = database.createStatement();
        selectSql = "UPDATE cuentas SET saldo = '" + String.valueOf(saldo) + "' WHERE numero_cuenta = '" + user + "'";
        stmt.executeUpdate(selectSql);
        stmt.close();
        rs.close();

        //Se crea una transaccion
        stmt = database.createStatement();
        String query = "INSERT INTO transacciones (cuenta_id,tipo,fecha,monto) VALUES('"+ user+ "',"+String.valueOf(3)+",'"+ fecha +"',"+String.valueOf(-1*monto)+")";
        stmt.executeUpdate(query);
        stmt.close();

        //Se obtiene el ultimo id de transaccion
        stmt = database.createStatement();
        query = "SELECT MAX(transaccion_id) AS transaccion_id  FROM transacciones";
        rs = stmt.executeQuery(query);
        int transaccion_id = rs.getInt("transaccion_id"); // Valor del ultimo ID 
        stmt.close();

        //Se obtiene el id de la tarjeta
        selectSql = "SELECT tarjeta_id FROM tarjetas WHERE numero_tarjeta = '" + nroTarjeta + "'";
        stmt = database.createStatement();
        rs = stmt.executeQuery(selectSql);
        int tarjeta_id = rs.getInt("tarjeta_id") ;
        stmt.close();

        //Se cargan los detalles en la tabla pago_tarjetas
        stmt = database.createStatement();
        query = "INSERT INTO pago_tarjetas (pago_id,tarjeta_id) VALUES("+ String.valueOf(transaccion_id) + "," + String.valueOf(tarjeta_id) +")";
        stmt.executeUpdate(query);
        stmt.close();

        String [] tarjetas = {"VISA", "MASTERCARD"};
        JOptionPane.showMessageDialog(null, "Ticket generado\nPago de Tarjeta\nNro de cuenta: " + 
                                                                "000" + user + "\nFecha: " + fecha + "\nMonto: " + monto + 
                                                                    "\nTarjeta: " + tarjetas[tipo] + " " + nroTarjeta);
        	
    }
    
    
    public static void impr(String[] arr){
        for (int k = 0; k<3; k++){
            System.out.print(arr[k] + "\t");
        }
        System.out.println("\n------------------------------------------");
    }
    
    public static void main(String [] args){
        try{
            pagoTc(1, 950000, "123 456 789", 0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
