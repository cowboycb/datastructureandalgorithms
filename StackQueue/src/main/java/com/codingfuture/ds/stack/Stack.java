package com.codingfuture.ds.stack;

public interface Stack<T> {

    void push(T v);
    T pop();
    T peek();
    boolean isEmpty();
}
