package ru.job4j.generic;

import java.util.*;

public class Test {

    public boolean check(String original, String anagram) {
        boolean result = false;
        char[] cg = original.toCharArray();
        char[] ck = anagram.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cg.length; i++) {
            if (map.containsKey(cg[i])) {
                map.put(cg[i], map.get(cg[i]) + 1);
            } else {
                map.put(cg[i], 1);
            }
        }
        System.out.println(map);

        for (int i = 0; i < ck.length; i++) {
            if (!map.containsKey(ck[i])) {
                break;
            } else {
                map.put(ck[i], map.get(ck[i]) - 1);
                if (map.get(ck[i]) == 0) {
                    map.remove(ck[i]);
                }
            }
        }

        if (map.isEmpty()) {
            result = true;
        }
        return result;
    }


    public static void main(String[] args) {
        Test test = new Test();
        String orig = "cllas";
        String anagram = "sslac";
        boolean res = test.check(orig, anagram);
        System.out.println(res);
    }
}
