package com.coursera.week2.exercise;

/**
 * Created by mato on 7/26/17.
 */
public class FixedCapacityStackofStrings {
    private String[] s;
    private int n = 0;

    public FixedCapacityStackofStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        s[n++] = item;
    }

    public String pop() {
        String item = s[--n];
        s[n] = null;
        if (n > 0 && n == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    private void resize(int size)
    {
        String[] copy = new String[size];
        for (int i =0; i < n; i++)
        {
            copy[i] = s[i];
        }

        s = copy;
    }
}
