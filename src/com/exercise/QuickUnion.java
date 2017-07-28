package com.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mato on 3/29/17.
 */
public class QuickUnion {
    private int ids[];
    private  int count;

    public static void main(String[] args)
    {
        String path = System.getProperty("user.dir")+ File.separator+"largeUF.txt";
        List<String> content = null;
        try {
            StringBuffer sb = new StringBuffer();
            content = Files.readAllLines(Paths.get(path));
            int N = Integer.parseInt(content.get(0));
            QuickUnion uf = new QuickUnion(N);

            for (int i = 1; i< content.size(); i++) {
                String lineContent = content.get(i);
                String[] lineValues = lineContent.split(" ");
                int p = Integer.parseInt(lineValues[0].trim());
                int q = Integer.parseInt(lineValues[1].trim());
                boolean connected = uf.connected(p, q);
                if (p > 10 || q > 10)
                {
                    System.out.println("Connected => " + p + " " + q );
                }
                if (connected)
                {
                    sb.append(p).append(",");
                    sb.append(q).append(",");
                    System.out.println("Connected => " + p + " " + q );
                }
                else
                {
                    uf.union(p, q);
                    System.out.println("Union => " + p + " " + q );
                }
            }

            System.out.println("Components => " +sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  QuickUnion(int n){
        ids = new int[n];
        for (int i =0; i< n; i++)
        {
            ids[i] = i;
        }
    }

    private int root(int i)
    {
        validate(i);
        while (i != ids[i])
        {
            i = ids[i];
        }

        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union (int p, int q)
    {
        int i = root(p);
        int j = root(q);
        ids[i] = j;

        count--;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = ids.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public int grtCount() {
        return count;
    }
}
