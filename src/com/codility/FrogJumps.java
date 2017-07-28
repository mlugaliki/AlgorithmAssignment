package com.codility;

/**
 * Created by mato on 2/4/17.
 */
public class FrogJumps {
    public static void main(String[] args){
        FrogJumps f = new FrogJumps();
        int stepCount = f.solution(0, 105, 15);
        System.out.println("Steps " + stepCount);
    }
    private int solution(int X, int Y, int D){
        int actualDistance = Y - X;
        int steps = (actualDistance / D);// + ((actualDistance % D) > 0 ? 1 : 0);
        int distanceCovered = steps * D;
        int fullDistance = distanceCovered + X;

        if(fullDistance < Y){
            steps ++;
        }

        return steps;
    }
}
