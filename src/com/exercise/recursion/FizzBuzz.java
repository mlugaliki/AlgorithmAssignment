package com.exercise.recursion;

/**
 * Created by mato on 4/9/17.
 */
public class FizzBuzz {
    public static void main(String[] args)
    {
        FizzBuzz buzz = new FizzBuzz();
        buzz.getFizzBuzz(100);
    }

    private void getFizzBuzz(int number)
    {
        for (int i =1; i <=number; i++)
        {
            if (i % 3 == 0)
            {
                printResult("Fizz "+i);
            }

            if (i % 5 == 0)
            {
                printResult("Buzz "+i);
            }

            if (i % 3 == 0 && i % 5 == 0)
            {
                printResult("FizzBuzz "+i);
            }
        }
    }

    private void printResult(String message) {
        System.out.println(message);
    }
}
