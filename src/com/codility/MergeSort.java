package com.codility;

import java.util.Arrays;

/**
 * Created by mato on 2/4/17.
 */
public class MergeSort {

    private int[] myArray = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
    private int[] temp;

    public static void main(String a[]) {

        //int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        MergeSort mms = new MergeSort();
        mms.temp = new int[mms.myArray.length];
        mms.sortArrayByMergeSort(0, mms.myArray.length -1);

        System.out.println(Arrays.toString(mms.myArray));
    }

    private void sortArrayByMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            sortArrayByMergeSort(lowerIndex, middle);
            sortArrayByMergeSort(middle + 1, higherIndex);
            mergeArrayParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeArrayParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = myArray[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temp[i] <= temp[j]) {
                myArray[k] = temp[i];
                i++;
            } else {
                myArray[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            myArray[k] = temp[i];
            k++;
            i++;
        }

    }
}
