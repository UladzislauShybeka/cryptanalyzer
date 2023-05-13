package com.javarush.cryptanalyzer.shybeka.function;

public class DecodingByKey {
    public static String decodeByKey(char[] alphabet, char[] array, int shift) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            char currentChar = array[i];

            for (int b = 0; b < alphabet.length; b++) {
                if (currentChar == alphabet[b]) {
                    int index = (b - shift + alphabet.length) % alphabet.length;
                    if(index < 0) {
                        index = alphabet.length + index;
                    }
                    stringBuilder.append(alphabet[index]);
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }
}
