package com.javarush.cryptanalyzer.shybeka.function;

public class DecodingByKey {
    public static String decodeByKey(char[] alphabet, char[] array, int shift) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int b = 0; b < alphabet.length; b++) {
                int number = b - shift;
                int index = number % alphabet.length;
                if (array[i] == alphabet[b]) {
                    stringBuilder.append(alphabet[index]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
