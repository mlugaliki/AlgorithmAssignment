package com.coursera.codility;

/**
 * Created by mato on 2/5/17.
 */
public class CodilityExample {
    public static void main(String[] args){
        CodilityExample codility = new CodilityExample();
        int [] A = { -1, 3, -4, 5, 1, -6, 2, 1 };
        int result = codility.solution(A);
        //System.out.println(result);
    }

    public int solution(int[] A) {
        if(A == null || A.length == 0){
            return  -1;
        }

        for (int i = 1; i < A.length; i++){
            int upperCount = upperCount(A, i);
            int lowerCount = lowerCount(A, i);

            if(upperCount == lowerCount){
                return i;
            }
            if(i == A.length -1){
                if(lowerCount == 0){
                    return i;
                }
            }
        }

        return -1;
    }

    private int upperCount(int[] A, int index) {
        int count = 0;
        if(index == (A.length-1))
        {
            return A[A.length-1];
        }
        for(int i =index + 1; i < A.length; i++)
        {
            count += A[i];
        }

        return count;
    }

    private int lowerCount(int[] A, int index) {
        int count = 0;
        if(index == 1){
            return A[0];
        }

        for(int i = 0; i <index; i++)
        {
            count += A[i];
        }

        return count;
    }
}
