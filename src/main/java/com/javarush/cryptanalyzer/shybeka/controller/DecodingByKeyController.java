package com.javarush.cryptanalyzer.shybeka.controller;

import com.javarush.cryptanalyzer.shybeka.constants.ApplicationConstants;
import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.files.InPut;
import com.javarush.cryptanalyzer.shybeka.files.OutPut;
import com.javarush.cryptanalyzer.shybeka.function.DecodingByKey;

import javax.swing.*;
import java.io.IOException;


public class DecodingByKeyController {
    public static void decodeControl() {
        String path = JOptionPane.showInputDialog(null, ApplicationConstants.PATH);
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;

        if (path != null) {
            try {
                text = InPut.toText(path);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, ApplicationConstants.FILE_NOT_FOUND);

            }

            String keyString = JOptionPane.showInputDialog(null, ApplicationConstants.ENTER_THE_KEY);
            if (keyString != null) {
                try {
                    int key = Integer.parseInt(keyString);
                    String decryptedText = DecodingByKey.decodeByKey(alphabet, text, key);
                    OutPut.toFile(decryptedText);

                    JOptionPane.showMessageDialog(null, ApplicationConstants.DECODED_TEXT + decryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, ApplicationConstants.WRONG_FORMAT_KEY);
                }

                String decryptedText = DecodingByKey.decodeByKey(alphabet, text, 5);
                OutPut.toFile(decryptedText);

                JOptionPane.showMessageDialog(null, ApplicationConstants.DECODED_TEXT + decryptedText);
            }
        }
    }
}
