package com.javarush.cryptanalyzer.shybeka.view;

import com.javarush.cryptanalyzer.shybeka.controller.BrutForceController;
import com.javarush.cryptanalyzer.shybeka.controller.DecodingByKeyController;
import com.javarush.cryptanalyzer.shybeka.controller.EncodeController;
import com.javarush.cryptanalyzer.shybeka.function.Encoding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View extends JFrame {
    public View() {
        setTitle("Шифр цезаря");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();

        JButton brutForceButton = new JButton("Расшифровать текст методом Brut Force");
        JButton decryptByKeyButton = new JButton("Расшифровать текст по ключу");
        JButton encryptByKeyButton = new JButton("Зашифровать текст по ключу");

        brutForceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BrutForceController.brutForceDecryption();
            }
        });

        decryptByKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecodingByKeyController.decodeControl();
            }
        });

        encryptByKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncodeController.encodeControl();
            }
        });

        panel.add(brutForceButton);
        panel.add(decryptByKeyButton);
        panel.add(encryptByKeyButton);

        add(panel);
        setVisible(true);
    }

}


