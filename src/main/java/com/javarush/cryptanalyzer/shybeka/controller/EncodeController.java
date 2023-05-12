package com.javarush.cryptanalyzer.shybeka.controller;

import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.function.Encoding;

import javax.swing.*;
import java.io.IOException;


public class EncodeController {
    public static void encodeControl() {
        String path = JOptionPane.showInputDialog(null, "Введите путь к файлу");
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;
        int key = 0;

        if (path != null) {
            try {
                text = InPut.toChars(path);
            } catch (IOException e) {
                System.out.println("Файл не найден");
            }
            String keyString = JOptionPane.showInputDialog(null, "Введите ключ (целое число)");
            if (keyString != null) {
                try {
                    key = Integer.parseInt(keyString);
                    String decryptedText = Encoding.encode(alphabet, text, key);
                    OutPut.toFile(decryptedText);

                    JOptionPane.showMessageDialog(null, "Засшифрованный текст:\n" + decryptedText);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный формат ключа");
                }

                String decryptedText = Encoding.encode(alphabet, text, key);
                OutPut.toFile(decryptedText);

                JOptionPane.showMessageDialog(null, "Засшифрованный текст:\n" + decryptedText);
            }
        }
    }
}