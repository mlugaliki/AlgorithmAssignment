package com.coursera.week2.assignment;

import com.coursera.week2.exercise.Stack;

import java.util.Iterator;

/**
 * Created by mato on 7/28/17.
 */
public class Deque<Item> implements Iterable<Item>
{
    private int size;
    private Node first;

    // construct an empty deque
    public Deque()
    {

    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size() == 0;
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        size++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    // add the item to the end
    public void addLast(Item item)
    {
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        size--;
        return null;
    }

    // remove and return the item from the end
    public Item removeLast()
    {
        size --;
        return null;
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator()
    {
        ListIterator listIterator = new ListIterator();
        return listIterator;
    }

    // unit testing (optional)
    public static void main(String[] args)
    {
        Deque deque = new Deque();
        deque.isEmpty();
    }

    private class  Node
    {
        Item item;
        Node next;
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
}
