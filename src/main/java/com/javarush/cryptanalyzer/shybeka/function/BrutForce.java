package com.javarush.cryptanalyzer.shybeka.function;

import java.util.ArrayList;
import java.util.Collections;

public class BrutForce {
    public static String brutForceDecode(char[] alphabet, char[] array, ArrayList<Integer> spaces) {
        ArrayList<Character> list = new ArrayList<>();
        for (int shift = 0; shift < alphabet.length; shift++) {
            list.clear();
            for (int i = 0; i < array.length; i++) {
                for (int b = 0; b < alphabet.length; b++) {
                    int number = (b - shift + alphabet.length) % alphabet.length;
                    if (array[i] == alphabet[b]) {
                        list.add(alphabet[number]);
                        break;
                    }
                }
            }
            spaces.add(countSpaces(list, alphabet));
        }
        int point = findMaxSpace(list, spaces);
        return ResultForBrutForce.showResult(alphabet,array,list,point);
    }

    public static int countSpaces(ArrayList<Character> list, char[] alphabet) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public static int findMaxSpace(ArrayList<Character> list, ArrayList<Integer> spaces) {
        return Collections.max(spaces);
    }
}


