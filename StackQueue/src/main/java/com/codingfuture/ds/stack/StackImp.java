package com.codingfuture.ds.stack;

import java.util.EmptyStackException;

public class StackImp<T> implements Stack<T> {

    T[] datas;
    int top;

    public StackImp(int maxsize) {
        this.top = -1;
        this.datas = (T[]) new Object[maxsize];
    }

    @Override
    public void push(T v) {
        if (top == datas.length - 1) {
            throw new RuntimeException("Stack Full");
        }
        //System.out.println("Pushed " + v);
        datas[++top] = v;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T data = datas[top--];
        //System.out.println("Popped " + data);
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return datas[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
