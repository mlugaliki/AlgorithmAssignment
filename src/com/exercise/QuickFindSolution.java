package com.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Used to solve dynamic connectivity problem
 */
public class QuickFindSolution {

    private  int[] ids;

    public static void main(String[] args)
    {
        try {
            String path = System.getProperty("user.dir")+ File.separator+"largeUF.txt";
            List<String> content = Files.readAllLines(Paths.get(path));
            int N = Integer.parseInt(content.get(0));
            QuickFindSolution uf = new QuickFindSolution(N);

            for (int i = 1; i< content.size(); i++)
            {
                String lineContent = content.get(i);
                String[] lineValues = lineContent.split(" ");
                int p = Integer.parseInt(lineValues[0].trim());
                int q = Integer.parseInt(lineValues[1].trim());
                if (!uf.connected(p, q))
                {
                    uf.union(p, q);
                    System.out.println("Connected => " + p + " " + q);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public QuickFindSolution(int n)
    {
        ids = new int[n];
        for (int i =0; i < n; i++)
        {
            ids[i] = i;
        }
    }

    public boolean connected (int p, int q)
    {
        boolean connected = ids[p] == ids[q];
        if (connected)
        {
            System.out.println("Value 1 =  " + ids[p] + " Value 2 = " + ids[q]);
        }

        return connected;
    }

    public void union(int p, int q)
    {
        int pid = ids[p];
        int qid = ids[q];

        for (int i = 0; i<ids.length; i++)
        {
            if(ids[i] == pid) ids[i] = qid;
        }
    }
}
