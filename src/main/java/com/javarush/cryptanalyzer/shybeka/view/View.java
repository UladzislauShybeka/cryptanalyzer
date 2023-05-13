package com.javarush.cryptanalyzer.shybeka.view;

import com.javarush.cryptanalyzer.shybeka.constants.ApplicationConstants;
import com.javarush.cryptanalyzer.shybeka.controller.BrutForceController;
import com.javarush.cryptanalyzer.shybeka.controller.DecodingByKeyController;
import com.javarush.cryptanalyzer.shybeka.controller.EncodeController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    public View() {
        setTitle("Шифр Цезаря");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Открытие окна посередине экрана

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE); // Фон панели - белый

        JButton brutForceButton = new JButton(ApplicationConstants.DECODE_BRUT);
        JButton decryptByKeyButton = new JButton(ApplicationConstants.DECODE_BY_KEY);
        JButton encryptByKeyButton = new JButton(ApplicationConstants.CODE_BY_KEY);

        brutForceButton.setOpaque(true);
        brutForceButton.setBackground(Color.GREEN); // Зеленый цвет кнопки

        decryptByKeyButton.setOpaque(true);
        decryptByKeyButton.setBackground(Color.ORANGE); // Оранжевый цвет кнопки

        encryptByKeyButton.setOpaque(true);
        encryptByKeyButton.setBackground(Color.BLUE); // Синий цвет кнопки

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
