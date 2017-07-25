package com.coursera.codility;

/**
 * Created by mato on 2/4/17.
 */
public class MissingElementInArray {
    private int[] array;
    private int[] tempMergArr;

    public static void main(String[] args){
        /*MissingElementInArray me = new MissingElementInArray();
        int []A = {2,3,1,5};
        int element = me.Solution(A);
        System.out.println(element);*/

        int n = 20;
        int result = n * (n + 1);
        result = 0;
        for(int i =0; i<n; i++){
            result += n +1;
        }
        System.out.println(result);
    }

    private int Solution(int[] A) {
        int B[] = new int[A.length + 1];
        int sumA =  0;
        int sumB = 0;
        // Sort array in ascending order
        A = sort(A);
        int N = A[0];

        for(int i =0; i<B.length; i++){
            B[i] =  N++;
            sumB +=B[i];

            if(i < A.length){
                sumA +=A[i];
            }
        }

        int missingValue = sumB - sumA;
        return missingValue;
    }

    // Sort the array ascending
    public int[] sort(int inputArr[]) {
        this.array = inputArr;
        int length = inputArr.length;
        this.tempMergArr = new int[length];
        return doMergeSort(0, length - 1);
    }

    private int[] doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
        return array;
    }

    private int[] mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

        return array;
    }
}
