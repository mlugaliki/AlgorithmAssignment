package com.coursera.week2.exercise;

/**
 * Created by mato on 7/27/17.
 */
public class QueueOfStringsByLinkedList
{
    private Node first = null;
    private Node last;
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

    public  void enqueue(String item)
    {
        Node oldlast =  last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }
    }

    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        if (isEmpty())
        {
            last = null;
        }
        return item;
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
