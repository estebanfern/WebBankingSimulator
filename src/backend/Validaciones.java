/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

/**
 *
 * @author esteb
 */
public class Validaciones {
    
    public static Integer getPin(){
        return ThreadLocalRandom.current().nextInt(1000, 9999+1); 
    }

    public static boolean validarTransaccion(){
        Integer pin = Validaciones.getPin();
        JOptionPane.showMessageDialog(null, "Su PIN de transacción es: " + pin);
        String entrada = JOptionPane.showInputDialog(null, "Ingrese el PIN de transacción");
        try{
            if(pin.equals(Integer.parseInt(entrada))){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "PIN de transacción incorrecto.");
                return false;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR, solo se permiten valores enteros.");
            return false;
        }
    }

    public static boolean validarCuenta(String cuenta){
        try{
            //Integer num = Integer.parseInt(cuenta);
            Integer.parseInt(cuenta);
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR, solo se permiten valores enteros.");
            return false;
        }
    }
    
    public static boolean validarMonto(String monto){
        try{
            //Integer num = Integer.parseInt(monto);
            Integer.parseInt(monto);
            if (Integer.parseInt(monto) < 0){
                throw new Exception("Error, monto negativo");
            }
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR, solo se permiten valores enteros positivos.");
            return false;
        }
        
    }

}
