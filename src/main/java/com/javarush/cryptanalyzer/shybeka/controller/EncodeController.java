package com.javarush.cryptanalyzer.shybeka.controller;

import com.javarush.cryptanalyzer.shybeka.constants.ApplicationConstants;
import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.files.InPut;
import com.javarush.cryptanalyzer.shybeka.files.OutPut;
import com.javarush.cryptanalyzer.shybeka.function.Encoding;

import javax.swing.*;
import java.io.IOException;


public class EncodeController {
    public static void encodeControl() {
        String path = JOptionPane.showInputDialog(null, ApplicationConstants.PATH);
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;
        int key = 0;

        if (path != null) {
            try {
                text = InPut.toText(path);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, ApplicationConstants.FILE_NOT_FOUND);
            }

            String keyString = JOptionPane.showInputDialog(null, ApplicationConstants.ENTER_THE_KEY);
            if (keyString != null) {
                try {
                    key = Integer.parseInt(keyString);
                    String decryptedText = Encoding.encode(alphabet, text, key);
                    OutPut.toFile(decryptedText);

                    JOptionPane.showMessageDialog(null, ApplicationConstants.CODED_TEXT + decryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, ApplicationConstants.WRONG_FORMAT_KEY);
                }

                String decryptedText = Encoding.encode(alphabet, text, key);
                OutPut.toFile(decryptedText);

                JOptionPane.showMessageDialog(null, ApplicationConstants.CODED_TEXT + decryptedText);
            }
        }
    }
}