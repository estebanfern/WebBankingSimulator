/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author esteb
 */
public class Formatear {
    public static String monto(String monto){
        String cadena = "";
        int count = 0;
        for (int k = monto.length()-1; k>-1; k--){
            if (count == 3){
                cadena = monto.charAt(k) + "." + cadena;
                count = 0;
            }else{
                cadena = monto.charAt(k) + cadena;
            }
            count ++;
        }
        return cadena + " Gs.";
    }

    public static void main(String[] args) {
        System.out.println(monto("1525000"));    
    }
}
