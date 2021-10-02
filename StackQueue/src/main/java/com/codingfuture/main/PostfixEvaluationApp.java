package com.codingfuture.main;

import com.codingfuture.ds.infixpostfix.PostfixEvaluation;

public class PostfixEvaluationApp {
    public static void main(String[] args) {
        System.out.println(PostfixEvaluation.evaluate("36+"));
        System.out.println(PostfixEvaluation.evaluate("36*"));
        System.out.println(PostfixEvaluation.evaluate("365*+"));
    }
}
