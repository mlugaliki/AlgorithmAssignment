package com.coursera.week2.exercise;

import java.util.Iterator;

/**
 * Created by mato on 7/27/17.
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first = null;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class  Node
    {
        public Item item;
        public Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return  item;
    }
}
