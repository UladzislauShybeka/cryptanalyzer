package com.javarush.cryptanalyzer.shybeka.controller;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import com.javarush.cryptanalyzer.shybeka.constants.ApplicationConstants;
import com.javarush.cryptanalyzer.shybeka.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.shybeka.files.InPut;
import com.javarush.cryptanalyzer.shybeka.files.OutPut;
import com.javarush.cryptanalyzer.shybeka.function.BrutForce;

import java.io.IOException;


public class BrutForceController {
    public static void brutForceDecryption() {
        String path = JOptionPane.showInputDialog(null, ApplicationConstants.PATH);
        char[] text = null;
        char[] alphabet = CryptoAlphabet.alphabet;
        ArrayList<Integer> spaces = new ArrayList<>();

                try {
                    text = InPut.toText(path);
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(null, ApplicationConstants.FILE_NOT_FOUND);
                }


            String decryptedText = BrutForce.brutForceDecode(alphabet, text, spaces);
            OutPut.toFile(decryptedText);

            JOptionPane.showMessageDialog(null, ApplicationConstants.DECODED_TEXT + decryptedText);
        }
    }

