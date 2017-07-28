package com.coursera.week2.exercise;

/**
 * Created by mato on 7/26/17.
 */
public class TestMain {
    public static  void main(String[] args)
    {
        LinkedListOfStrings names = new LinkedListOfStrings();
        names.push("Martin");
        names.push("Rose");
        names.push("Lenny");
        names.push("Kevin");
        names.push("Lenox");
        names.push("Lijux");

        System.out.println("Size " + names.size());
        System.out.println("IsEmpty " + names.isEmpty());
        int size = names.size();
        for (int i =0; i <size; i++)
        {
            System.out.println("Name " + names.pop());
        }

        System.out.println("Size after popping " + names.size());
    }
}
