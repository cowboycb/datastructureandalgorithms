package com.codingfuture.ds.infixpostfix;

import com.codingfuture.ds.stack.Stack;
import com.codingfuture.ds.stack.StackImp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PostfixEvaluation {

    private static List<Character> operators = Arrays.asList('+', '-', '/', '*');

    private static Stack<Integer> stack;

    public static int evaluate(String postfix){
        stack = new StackImp<>(postfix.length());
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (operators.contains(c)){
                operate(c);
            }else{
                stack.push(c - '0');
            }
        }

        return stack.pop();
    }

    private static void operate(char c) {
        int x1 = stack.pop();
        int x2 = stack.pop();
        int result = 0;
        switch (c){
            case '+':
                result = x1 + x2; break;
            case '-':
                result = x2 - x1; break;
            case '/':
                result = x2/x1; break;
            case '*':
                result = x2*x1;
                break;
        }
        stack.push(result);
    }

}
