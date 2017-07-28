package com.coursera.week1.exercise;

import com.coursera.week1.assignment.Percolation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mato on 7/25/17.
 */
public class TestClass {
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir") + File.separator + "input6.txt";
            List<String> content = Files.readAllLines(Paths.get(path));
            int N = Integer.parseInt(content.get(0));
            Percolation uf = new Percolation(N);


            System.out.println("Starting to open random sites...");
            int row, col, ct;
            double sum = 0.0;
            for (int i = 1; i <= N; i++) {
                ct = 0;
                String lineContent = content.get(i);
                String[] lineValues = lineContent.split(" ");
                int p = Integer.parseInt(lineValues[0].trim());
                int q = Integer.parseInt(lineValues[1].trim());
                uf.open(p, q);
                uf.percolates();
                uf.isFull(p, q);

                System.out.println("Open = " + uf.isFull(p, q));
                System.out.println("Percolate = " + uf.percolates());
                System.out.println("No of open sites = " + uf.numberOfOpenSites());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
