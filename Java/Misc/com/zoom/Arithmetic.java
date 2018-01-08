package com.zoom;

import java.util.*;

public class Arithmetic {
    public static int evaluate(String s) throws Exception {
        List<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int op = 0; // 0: none, 1: multiply, 2: division
        boolean sign = s.charAt(0) == '-';
        int start = sign ? 1 : 0;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                if (sb.length()==0) throw new Exception("no num");
                int num = Integer.valueOf(sb.toString());
                if (sign) num = -num;
                sb = new StringBuffer();
                if (op == 1) {
                    list.set(list.size()-1, list.get(list.size()-1)*num);
                    op = 0;
                } else if (op == 2) {
                    list.set(list.size()-1, list.get(list.size()-1)/num);
                    op = 0;
                } else {
                    list.add(num);
                }
                sign = c == '-';
                if (c == '*') op = 1;
                else if (c == '/') op = 2;
            } else
                throw new Exception("Invalid");
        }
        int result = Integer.valueOf(sb.toString());
        if (sign) result = -result;
        if (op == 1) {
            result = list.get(list.size()-1)*result;
        } else if (op == 2) {
            result = list.get(list.size()-1)/result;
        }

        for (int num : list)
            result += num;

        return result;
    }

    public static void main(String args[]) {
        String s = "3+4";
        String s1 = "5+2*3+1";
        String s2 = "-2+5+3*2*3/2+3-2*3-1";
        String s3 = "-2+5+3*2*3/2+3-2*3-*1";

        try {
            System.out.println(evaluate(s));
            System.out.println(evaluate(s1));
            System.out.println(evaluate(s2));
            System.out.println(evaluate(s3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
