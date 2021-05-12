package com.example.string_reverse;

public class StringReverse {
    public static String reverse(String src, int firstIndex, int lastIndex){
        String destSubstring = src.substring(firstIndex, lastIndex);
        return reverse(src,destSubstring);
    }

    public static String reverse(String src, String dest){
        return src.replace(dest, reverse(dest));
    }

    public static String reverse(String src){
        char[] srcChars = src.toCharArray();
        for (int i = 0; i < srcChars.length/2; i++) {
            char tmp = srcChars[i];
            srcChars[i] = srcChars[srcChars.length-i-1];
            srcChars[srcChars.length-i-1] = tmp;
        }
        return String.valueOf(srcChars);
    }
}
