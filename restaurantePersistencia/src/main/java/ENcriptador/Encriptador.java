/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENcriptador;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encriptador {

//    private static final String ALGORITHM = "AES";
//    private static final String SECRET_KEY = "1234567890123456"; // 16-byte secret key, puedes cambiarla.

//    // Encriptar el texto
//    public static String encrypt(String text) throws Exception {
//        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
//        Cipher cipher = Cipher.getInstance(ALGORITHM);
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
//        return Base64.getEncoder().encodeToString(encryptedBytes);
//    }
//
//    // Desencriptar el texto
//    public static String decrypt(String encryptedText) throws Exception {
//        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
//        Cipher cipher = Cipher.getInstance(ALGORITHM);
//        cipher.init(Cipher.DECRYPT_MODE, keySpec);
//        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
//        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//        return new String(decryptedBytes);
//    }
    
    private static final String ALGORITMO = "AES";
    private static final String CLAVE = "1234567890123456";

    //encriptamos el telefono
    public static String encrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO); 
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cifrado = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(cifrado); 
        } catch (Exception e) {
            throw new RuntimeException("Error en la encriptación", e);
        }
    }
    //desencriptamos el telefono
    public static String decrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodificado = Base64.getDecoder().decode(input); 
            return new String(cipher.doFinal(decodificado)); 
        } catch (Exception e) {
            throw new RuntimeException("Error en la desencriptación", e);
        }
    }
    
}
