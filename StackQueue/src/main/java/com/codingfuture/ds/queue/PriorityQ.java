package com.codingfuture.ds.queue;

import java.util.Arrays;

public class PriorityQ {

    private long[] items;
    private int itemCount;

    public PriorityQ(int capacity) {
        items = new long[capacity];
        itemCount = 0;
    }

    public void add(long value) throws Exception {
        if (isFull()){
            throw new Exception("Queue is full");
        }
        if (itemCount == 0){
            items[itemCount] = value;
        }else{
            int i;
            for (i = itemCount - 1; i >= 0; i--) {
                if (items[i]<value){
                    items[i+1] = items[i];
                }else{
                    break;
                }
            }
            items[i+1] = value;
        }
        itemCount++;
    }

    private boolean isFull() {
        return itemCount == items.length;
    }

    public long remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int first = --itemCount;
        long item = items[first];
        items[first] = 0;
        return item;
    }

    public long peek() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return items[itemCount-1];
    }

    private boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    public String toString() {
        return "PriorityQ{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
