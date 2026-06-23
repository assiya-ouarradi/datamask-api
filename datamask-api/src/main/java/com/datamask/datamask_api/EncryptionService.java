package com.datamask.datamask_api;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

@Service
public class EncryptionService {

    private SecretKey secretKey;

    public EncryptionService() throws Exception {
        // Génère une clé AES-256 au démarrage
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        this.secretKey = keyGen.generateKey();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        // Convertit les bytes en texte lisible (Base64)
        return Base64.getEncoder().encodeToString(encrypted);
    }
}