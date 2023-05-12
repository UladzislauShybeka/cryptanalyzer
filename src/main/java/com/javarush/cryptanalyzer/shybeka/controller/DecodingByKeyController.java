package com.javarush.cryptanalyzer.shybeka.controller;

import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.function.DecodingByKey;

import javax.swing.*;
import java.io.IOException;


public class DecodingByKeyController {
    public static void decodeControl() {
        String path = JOptionPane.showInputDialog(null, "Введите путь к файлу");
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;

        if (path != null) {
            try {
                text = InPut.toChars(path);
            } catch (IOException e) {
                System.out.println("Файл не найден");
            }
            String keyString = JOptionPane.showInputDialog(null, "Введите ключ (целое число)");
            if (keyString != null) {
                try {
                    int key = Integer.parseInt(keyString);
                    String decryptedText = DecodingByKey.decodeByKey(alphabet, text, key);
                    OutPut.toFile(decryptedText);

                    JOptionPane.showMessageDialog(null, "Расшифрованный текст:\n" + decryptedText);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный формат ключа");
                }

                String decryptedText = DecodingByKey.decodeByKey(alphabet, text, 5);
                OutPut.toFile(decryptedText);

                JOptionPane.showMessageDialog(null, "Расшифрованный текст:\n" + decryptedText);
            }
        }
    }
}
