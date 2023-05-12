package com.javarush.cryptanalyzer.shybeka.controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;

public class OutPut {
    public static void toFile(String str) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Отменено");
        }
    }
}
