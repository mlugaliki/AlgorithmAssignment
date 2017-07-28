package com.exercise.recursion;

/**
 * Created by mato on 4/8/17.
 */
public class FactorialExample {
    public static void main(String [] args){
        FactorialExample fact = new FactorialExample();
        // fact.RecursionByLoop();
        fact.RecursionByRecursion(10);
    }

    private void RecursionByLoop() {
        int n = 2;
        int result = 0;
        for (int i = 1; i <=n; i++){
            if (i ==1)
            {
                System.out.println("Res 1 = "+ 1);
                continue;
            }

            int res = n * (n *(n -1));
            System.out.println("Res = "+res);
            result += res;
            System.out.println("Result = " + result);
        }
    }

    private int RecursionByRecursion(int n) {
        if (n ==  1){
            System.out.println("Result 1=" + 1);
            return  1;
        }

        int result = (n * RecursionByRecursion(n -1 ));
        System.out.println("Result "+n +"=" + result);
        return  result;
    }
}
