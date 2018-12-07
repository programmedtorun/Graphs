package com.alg;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by patrickskelley on Dec, 2018
 */
public class Graph {

        Integer[][] adjecencyMatrix;
        List<Integer> degreeSequence;

        private void addEdges(Integer v, Integer e)
        {
            for (int i = 0; i < adjecencyMatrix.length && e > 0; i++)
            {
                if (degreeSequence.get(i) != 0)
                {
                    adjecencyMatrix[v][i] = adjecencyMatrix[i][v] = 1;
                    Integer val = degreeSequence.get(i);
                    if (val > 0)
                        degreeSequence.set(i, val - 1);
                    e--;
                }
            }
        }

        public void generateGraph()
        {
            adjecencyMatrix = new Integer[degreeSequence.size()][degreeSequence
                    .size()];
            for (int i = 0; i < adjecencyMatrix.length; i++)
            {
                for (int j = 0; j < adjecencyMatrix.length; j++)
                {
                    adjecencyMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < degreeSequence.size(); i++)
            {
                Integer e = degreeSequence.get(i);
                degreeSequence.set(i, 0);
                addEdges(i, e);
            }
        }

        public void printGraph()
        {
            System.out.println("The matrix form of graph: ");
            for (int i = 0; i < adjecencyMatrix.length; i++)
            {
                for (int j = 0; j < adjecencyMatrix.length; j++)
                {
                    System.out.print(adjecencyMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
}
