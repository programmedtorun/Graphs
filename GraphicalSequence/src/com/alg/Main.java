package com.alg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HHGSequence sequence = new HHGSequence();

        ArrayList<Integer> potentialGList = new ArrayList<Integer>();
        Scanner reader = new Scanner(System.in);
        int graphSize;
        do {
            System.out.print("Please enter the number of nodes in your graph, a positive number: ");
            while (!reader.hasNextInt()) {
                String input = reader.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            graphSize = reader.nextInt();
        } while (graphSize < 0);


        Graph gds = new Graph();
        gds.degreeSequence = new ArrayList<Integer>();

            System.out.println("Values must be positive.");
            for (int i = 0; i < graphSize; i++){
                System.out.println("Please enter a value for your node: " );
                while(!reader.hasNextInt()){
                    System.out.println("That was not a valid number... please try again.");
                    reader.next();
                }
                int nodeToAdd = reader.nextInt();
                if (nodeToAdd < 0){
                    System.out.println("that was a negitive number bro...");
                    graphSize++;
                } else {
                    potentialGList.add(nodeToAdd);
                    gds.degreeSequence.add(nodeToAdd);
                }
            }
            if (sequence.isGraphical(potentialGList)){
                System.out.println("This is a graphical sequence.");
                System.out.println("Entered degree sequence: "
                        + gds.degreeSequence.toString());
                gds.generateGraph();
                gds.printGraph();
            } else {
                System.out.println("The degree sequence D is not graphic.");
                System.out.println("Entered degree sequence: "
                        + gds.degreeSequence.toString());
            }
    }
}
