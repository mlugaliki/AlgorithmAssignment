package com.coursera.week2.exercise;

/**
 * Created by mato on 7/26/17.
 */
public class LinkedListOfStrings {
    private Node first = null;
    private int count;

    private class Node
    {
        public String item;
        public Node next;
    }

    public boolean isEmpty()
    {
        return  first == null;
    }

    public void push(String item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        count++;
    }

    public String pop()
    {
        count--;
        String item = first.item;
        first = first.next;
        return  item;
    }

    public int size()
    {
        return  count;
    }
}
