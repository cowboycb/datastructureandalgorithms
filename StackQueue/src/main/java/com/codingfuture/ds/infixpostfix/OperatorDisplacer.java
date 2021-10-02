package com.codingfuture.ds.infixpostfix;

import com.codingfuture.ds.stack.Stack;
import com.codingfuture.ds.stack.StackImp;

public class OperatorDisplacer {

    private static final int PRECEDENCE_LOW = 1;
    private static final int PRECEDENCE_HIGH = 2;

    private Stack<Character> stack;

    public OperatorDisplacer() {

    }

    public String infix2PostFix(String infix) {
        StringBuilder output = new StringBuilder();
        stack = new StackImp<>(infix.length());
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    output.append(operate(c, getPrecedence(c)));
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    output.append(pop2ClosedBrace());
                    break;
                default:
                    output.append(c);
            }
        }
        output.append(pop2ClosedBrace());
        return output.toString();
    }

    private String pop2ClosedBrace() {
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop == '(') {
                break;
            } else {
                out.append(pop);
            }
        }
        return out.toString();
    }

    private String operate(char c, int precedence) {
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            int popPrec = getPrecedence(pop);
            if (popPrec < precedence) {
                stack.push(pop);
                break;
            } else {
                out.append(pop); break;
            }
        }
        stack.push(c);
        return out.toString();
    }

    private int getPrecedence(char c) {
        int precedence = 0;
        switch (c) {
            case '+':
            case '-':
                precedence = PRECEDENCE_LOW;
                break;
            case '*':
            case '/':
                precedence = PRECEDENCE_HIGH;
                break;
        }
        return precedence;
    }

}
