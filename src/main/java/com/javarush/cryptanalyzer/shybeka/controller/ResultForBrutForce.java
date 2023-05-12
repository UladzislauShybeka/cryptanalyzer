package com.javarush.cryptanalyzer.shybeka.controller;

import com.javarush.cryptanalyzer.shybeka.function.BrutForce;

import java.util.ArrayList;

public class ResultForBrutForce implements Results {
    public static String showResult(char[] alphabet, char[] array, ArrayList<Character> list, int point) {
        StringBuilder sb = new StringBuilder();
        for (int shift = 0; shift < alphabet.length; shift++) {
            list.clear();
            for (int i = 0; i < array.length; i++) {
                for (int b = 0; b < alphabet.length; b++) {
                    int index = (b - shift + alphabet.length) % alphabet.length;
                    if (array[i] == alphabet[b]) {
                        list.add(alphabet[index]);
                        break;
                    }
                }
            }
            if (BrutForce.countSpaces(list, alphabet) == point) {
                for (Character ch : list) {
                    sb.append(ch);
                }

                String result = sb.toString();
                System.out.println(result);
                return result;
            }
        }
        return null;
    }
}
