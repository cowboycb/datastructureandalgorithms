package com.codingfuture.main;

import com.codingfuture.ds.stack.Stack;
import com.codingfuture.ds.stack.StackImp;

import java.util.Scanner;

public class DelimiterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String next = scanner.next();
        while (!" ".equals(next)){
            boolean reversed = check(next);
            System.out.println("Checked Delimiters : " + reversed);
            System.out.print("Enter a new word: ");
            next = scanner.next();
        }
        System.out.println("Exited from delimiter app");
    }

    private static boolean check(String next) {
        Stack<Character> stack = new StackImp<>(next.length());
        boolean result = true;
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            result = checkDelimiter(stack, result, i, c);
        }
        return result;
    }

    private static boolean checkDelimiter(Stack<Character> stack, boolean result, int i, char c) {
        switch (c){
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case ')':
            case ']':
            case '}':
                if (!stack.isEmpty()) {
                    Character poppedChar = stack.pop();
                    if ((c == ')' && poppedChar != '(')
                            || (c == ']' && poppedChar != '[')
                            || (c == '}' && poppedChar != '{')) {
                        System.out.println("Error " + c + " at " + i);
                        result = false;
                    }
                }else{
                    System.out.println("Stack empty - error " + c + " at " + i);
                    result = false;
                }
                break;
            default: break;
        }
        return result;
    }

}
