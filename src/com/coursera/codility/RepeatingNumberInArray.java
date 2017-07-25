package com.coursera.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RepeatingNumberInArray {

    private int[] arr = {9, 3, 9, 3, 9, 7, 9, 7, 7};
    public static void main(String[] args) {
        RepeatingNumberInArray array = new RepeatingNumberInArray();
        // array.simpleSolution();
        // array.simpleSolution2();
        array.NotPairedNumber();
    }

    private void NotPairedNumber() {
        int count = 0;
        Map<Integer, Integer> paired = new HashMap<>();
        for(int i =0; i <arr.length; i++){
            if(paired.size() > 0){
                Integer m = paired.get(arr[i]);
                if(m !=null){
                    count = paired.get(arr[i]).intValue();
                    paired.remove(arr[i]);
                    paired.put(arr[i], count + 1);
                }else{
                    paired.put(arr[i], 1);
                }
            }
            else{
                paired.put(arr[i], 1);
            }
        }

        Iterator maps = paired.entrySet().iterator();

        while (maps.hasNext()){
            Map.Entry value = (Map.Entry)maps.next();
            log(value.getKey() + " " + value.getValue());
            int v = (int)value.getValue();
            if(v == 1 || v % 2 !=0){
                log("Got it => " + value.getKey());
                break;
            }
        }
    }

    private void simpleSolution2() {
        boolean [] tempCount = new boolean[arr.length];
        for(int i =0; i<arr.length; i++){
            tempCount[arr[i]] = true;
        }

        log(Arrays.toString(tempCount));
    }


    private void simpleSolution() {
        for(int i = 0; i<arr.length; i++){

            for(int j =i+1; i< arr.length; i++){
                if(arr[i] == arr[j]){
                    log("Repeating number "+arr[i]);
                }
            }
        }
    }

    private void log(String message) {
        System.out.println(message);
    }


}
