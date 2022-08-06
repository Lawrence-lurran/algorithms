package com.lurran.algorithms.algorithms;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/24 3:45 下午
 */
public class PolandeNotation {
    public static void main(String[] args) {

    }

    public static List<String> getList(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                }
                stack.push("" + res);
            }
        }


        return Integer.parseInt(stack.pop());
    }
}
