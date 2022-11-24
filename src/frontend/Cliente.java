/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;
import backend.PasswordStorage;
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
            database = DriverManager.getConnection("jdbc:sqlite:src/db/data.db");
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
        //System.out.println("PIN de usr = " + pin);
        //System.out.println("PIN de db = " + rs.getString("pin"));
        try{
            if (PasswordStorage.verifyPassword(pin, rs.getString("pin"))){
                database.close();
                return true;
            }
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "Ingrese una cuenta valida");
            return false;
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
            query = "INSERT INTO depositos (deposito_id,tipo,numero_cheque) VALUES("+ String.valueOf(transaccion_id) + "," + String.valueOf(tipo) + "," + String.valueOf(nroCheque) +")";
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

        if (monto > rs.getInt("saldo")){
            throw new SQLException("Mensaje");
        }

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

        database.close();
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

        if (monto > rs.getInt("saldo")){
            throw new SQLException("Mensaje");
        }

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

        database.close();
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
            //impr(arr);
        }

        database.close();
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

        if (monto > rs.getInt("saldo")){
            throw new SQLException("Mensaje");
        }

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

        database.close();

        String [] tarjetas = {"VISA", "MASTERCARD"};
        JOptionPane.showMessageDialog(null, "Ticket generado\nPago de Tarjeta\nNro de cuenta: " + 
                                                                "000" + user + "\nFecha: " + fecha + "\nMonto: " + monto + 
                                                                    "\nTarjeta: " + tarjetas[tipo] + " " + nroTarjeta);
        	
    }
    
    public static DefaultTableModel getTransacciones(int user, JTable tabla) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        Connection database = conectar();
        String selectSql = "SELECT * FROM transacciones WHERE cuenta_id = '" + user + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        
        String [] arr = new String[3];
        int op;
        while (rs.next()){
            op = rs.getInt("tipo");

            arr[0] = rs.getString("fecha");
            arr[2] = String.valueOf(rs.getInt("monto"));

            if (op == 0){
                arr[1] = getDescripcionDp(rs.getInt("transaccion_id"));
            }else if (op == 1){
                arr[1] = getDescripcionTf(rs.getInt("transaccion_id"), rs.getInt("monto"));
            }else if (op == 2){
                arr[1] = getDescripcionSv(rs.getInt("transaccion_id"));
            }else if (op == 3){
                arr[1] = getDescripcionTc(rs.getInt("transaccion_id"));
            }
            
            
            
            modelo.addRow(arr);
        }
        
        
        database.close();
        return modelo;
    }
    
    public static String getDescripcionDp(int id) throws SQLException{
        
        Connection database = conectar();
        String selectSql = "SELECT * FROM depositos WHERE deposito_id = '" + id + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);

        //System.out.println(rs.getInt("tipo"));
        if (rs.getInt("tipo") == 0){
            database.close();
            return "Deposito en Efectivo";
        }else{
            int nroCheque = rs.getInt("numero_cheque");
            database.close();
            return "Deposito en Cheque nro " + nroCheque;
        }
        
    }
    
    public static String getDescripcionTf(int id, int monto) throws SQLException{
        Connection database = conectar();
        
        if (monto < 0){
            String selectSql = "SELECT * FROM transacciones WHERE transaccion_id = '" + String.valueOf(id+1) + "'";
            Statement stmt = database.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);
            int info = rs.getInt("cuenta_id");
            database.close();
            return "Transferencia realizada a la cuenta nro 000" + info;
        }else{
            String selectSql = "SELECT * FROM transacciones WHERE transaccion_id = '" + String.valueOf(id-1) + "'";
            Statement stmt = database.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);
            int info = rs.getInt("cuenta_id");
            database.close();
            return "Transferencia recibida de la cuenta nro 000" + info;
        }
    }
    
    public static String getDescripcionSv(int id) throws SQLException {
        Connection database = conectar();
        String selectSql = "SELECT numero_servicios FROM servicios WHERE servicio_id = '" + String.valueOf(id) + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        
        String [] servicios = {"ESSAP", "ANDE", "COPACO", "NETFLIX"};
        
        int op = rs.getInt("numero_servicios");
        database.close();
        return "Pago de servicio de " + servicios[op];
    }
    
    public static String getDescripcionTc(int id) throws SQLException {
        Connection database = conectar();
        String selectSql = "SELECT tarjeta_id FROM pago_tarjetas WHERE pago_id = '" + String.valueOf(id) + "'";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);
        int tc_id = rs.getInt("tarjeta_id");
        String [] tarjetas = {"VISA", "MASTERCARD"};
        stmt.close();

        selectSql = "SELECT * FROM tarjetas WHERE tarjeta_id = '" + String.valueOf(tc_id) + "'";
        stmt = database.createStatement();
        rs = stmt.executeQuery(selectSql);

        int tipo = rs.getInt("tipo_tarjeta");
        String nroTc = rs.getString("numero_tarjeta");
        database.close();
        return "Pago de TC " + tarjetas[tipo] + " " + nroTc;
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
