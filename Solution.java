package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Ancient Rome

*/

public class Solution {
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;

        if (s == null || s.length() < 1)
            return 0;

        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (romanMap.get(ch) == null)
                return 0;
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            int current = romanMap.get(chars[i]);
            result += current;
            if (i > 0) {
                if ((chars[i] == 'X' || chars[i] == 'V') && chars[i - 1] == 'I') {
                    result -= 1;
                    i--;
                } else if ((chars[i] == 'L' || chars[i] == 'C') && chars[i - 1] == 'X') {
                    result -= 10;
                    i--;
                } else if ((chars[i] == 'D' || chars[i] == 'M') && chars[i - 1] == 'C') {
                    result -= 100;
                    i--;
                }
            }
        }
        return result;
    }
}
