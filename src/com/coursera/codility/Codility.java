package com.coursera.codility;

/**
 * Created by mato on 2/5/17.
 */
public class Codility {
    int mod = 1000000007;
    int c =0;
    public static void main(String[] args){
        int [] A = { -3, -2, 1, 0, 8, 7, 1 };
        int M = 3;
        Codility codility = new Codility();
        // int result = codility.solution(A, M);
        int result = codility.solution2(3,4,5);
        System.out.println(result);
    }

    public int solution(int[] A, int M) {
        int count = 0;
        for(int i =0; i< A.length; i++){
            for(int k = i + 1; k< A.length -1; k++){
                int res = A[i] + A[k];
                if(res % M == 0){
                    count ++;
                }
            }
        }
        return count;
    }

    public int solution2(int A, int B, int N) {
        int mod1 = A % mod;
        int mod2 = B % mod;
        int prevMod =mod2;
        int currentMod = mod1 + mod2;
        int [] a = new int[N];
        a[0] = mod1;
        a[1] = mod1;
        for(int i= 1; i<N ;i++){
            currentMod = a[i-1] + a[i];
            a[i] = currentMod;
        }
        return currentMod;
    }

    private void remainder(int a, int b, int n) {
    }
}
