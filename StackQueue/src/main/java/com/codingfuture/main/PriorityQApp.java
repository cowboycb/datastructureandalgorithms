package com.codingfuture.main;

import com.codingfuture.ds.queue.PriorityQ;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityQApp {

    public static void main(String[] args) throws Exception {
        PriorityQ q = new PriorityQ(5);

        q.add(32);
        q.add(43);
        q.add(21);
        q.add(98);
        q.add(54);

        Queue<String> qd = new LinkedList<>();
        System.out.println(q);

        long remove = q.remove();
        System.out.println("Removed " + remove);
        System.out.println(q);
    }
}
