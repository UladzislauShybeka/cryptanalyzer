package com.javarush.cryptanalyzer.shybeka.controller;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.function.BrutForce;

import java.io.IOException;


public class BrutForceController {
    public static void brutForceDecryption() {
        String path = JOptionPane.showInputDialog(null, "Введите путь к файлу");
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;
        ArrayList<Integer> spaces = new ArrayList<>();
        if (path != null) {
            try {
                text = InPut.toChars(path);
            }
            catch (IOException e) {
                System.out.println("Файл не найден");
            }


            String decryptedText = BrutForce.brutForceDecode(alphabet, text, spaces);
            OutPut.toFile(decryptedText);

            JOptionPane.showMessageDialog(null, "Расшифрованный текст:\n" + decryptedText);
        }
    }
}

