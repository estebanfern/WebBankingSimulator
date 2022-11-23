package backend;

import backend.PasswordStorage.CannotPerformOperationException;

public class prueba{
    public static void main (String [] args) throws CannotPerformOperationException{
        String contra = "2121";
        System.out.println(PasswordStorage.createHash(contra));
        
    }
}