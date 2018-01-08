package com.zoom;
import java.util.Arrays;

public class FindSmallest{
    public static boolean contains(int[] arr, int key) {
        for (int a: arr)
            if (a == key) return true;
        return false;
    }

    public static String findSmallest(String s, char[] chars) {
       int s_idx = 0;
       int length = s.length();
       int current = 0;
       String sc = String.valueOf(chars);

       while (current < s.length() - chars.length) {
            int[] check = new int[chars.length];
            for (int i = 0; i < check.length; i++) {
                check[i] = -1;
            }
            for (int i = current; i < s.length(); i++) {
                if (sc.contains(String.valueOf(s.charAt(i))) &&
                        check[sc.indexOf(s.charAt(i))]==-1) {
                    check[sc.indexOf(s.charAt(i))] = i;
                }
                if (!contains(check,-1))
                    break;

            }
            if (!contains(check,-1)) {
                Arrays.sort(check);
                int c_s = check[0];
                int c_e = check[check.length-1];
                if (c_e - c_s + 1 < length) {
                    s_idx = c_s;
                    length = c_e - c_s + 1;
                }
                current = s_idx+1;
                    
            } else
                break;
       }
       return s.substring(s_idx,s_idx+length);
    }

    public static void main(String args[]) {
        String s = "amazonlab";
        char[] chars = new char[]{'n','a','m'};

        System.out.println(findSmallest(s, chars));
    }
}
