package com.javarush.cryptanalyzer.shybeka.files;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class InPut {
    public static char[] toText(String path) throws IOException {

        File file = new File(path);
        StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(file)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                sb.append((char) character);
            }
        }

        return sb.toString().toCharArray();
    }
    }

