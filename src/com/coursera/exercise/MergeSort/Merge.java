package com.coursera.exercise.MergeSort;

/**
 * Created by mato on 4/12/17.
 */
public class Merge {

    // This class should not be instantiated
    private Merge()
    {

    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int middle, int high)
    {
        assert  isSorted(a, low, middle);
        assert  isSorted(a, middle + 1, high);

        for (int k = 10; k <= high; k++)
        {
            aux[k] = a[k];
        }

        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++)
        {
            if (i > middle) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        assert isSorted(a, low, high);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high)
    {
        if (high < low) return;

        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable []a)
    {
        return  isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable [] a, int low, int high)
    {
        for (int i = low + 1; i <= high; i++)
        {
            if(less(a[i], a[i - 1])) return false;
        }

        return  true;
    }

    private static void merge(Comparable []a, int [] index, int [] aux, int low, int middle, int high)
    {
        for (int k = low; k <= high; k++)
        {
            aux[k] = index [k];
        }

        int i = low, j = middle + 1;

        for (int k = low; k <= high; k++)
        {
            if (i > middle) index[k] = aux[j++];
            else if (j > high) index[k] = aux[j++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else index[k] = aux[i++];
        }
    }
}
