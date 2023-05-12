package com.javarush.cryptanalyzer.shybeka.function;


public class Encoding {
    public static String encode(char[] alphabet, char[] array, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int b = 0; b < alphabet.length; b++) {
                if (array[i] == alphabet[b]) {
                    int index = (b + n) % alphabet.length;
                    result.append(alphabet[index]);

                }
            }
        }

        return result.toString();
    }
}