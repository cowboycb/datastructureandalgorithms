package com.codingfuture.main;

import com.codingfuture.ds.stack.Stack;
import com.codingfuture.ds.stack.StackImp;

import java.util.Scanner;

public class ReverseApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String next = scanner.next();
        while (!" ".equals(next)){
            String reversed = reverse(next);
            System.out.println("Reversed : " + reversed);
            System.out.print("Enter a new word: ");
            next = scanner.next();
        }
        System.out.println("Exited from reversed app");
    }

    private static String reverse(String word) {
        Stack<Character> stack = new StackImp<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.toString();
    }


}
