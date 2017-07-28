package com.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mato on 2/4/17.
 */
public class TapeEquilibrium {
    public static void main(String[] args){
        int[] A = { 3, 1, 2, 4, 3 };
        TapeEquilibrium tape = new TapeEquilibrium();
        tape.Solution(A);
    }

    private int Solution(int[] A) {
        List<Integer> result = new ArrayList<>();
        if(A == null){
            return 0;
        }

        if(A.length == 0){
            return 0;
        }
        for(int i = 1; i < A.length; i++){
            int lowerCount = lowerCount(A, i);
            int upperCount = upperCount(A, i);
            int res = lowerCount - upperCount;
            result.add(Math.abs(res));
        }

        Collections.sort(result);
        return result.get(0);
    }

    private int upperCount(int[] A, int index) {
        int count = 0;
        for(int i =index; i < A.length; i++)
        {
            count += A[i];
        }

        return count;
    }

    private int lowerCount(int[] A, int index) {
        int count = 0;
        for(int i =0; i <index; i++)
        {
            count += A[i];
        }

        return count;
    }
}
