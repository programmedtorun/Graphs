package com.alg;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by patrickskelley on Dec, 2018
 */
public class HHGSequence {

    boolean isGraphical(ArrayList<Integer> sequence){
        System.out.println("size: " + (sequence.size()));

        if ((sequence.size() == 2
                && sequence.get(0) == 0
                && sequence.get(1) == 0)
                || sequence.size() == 0) {
            return true;
        } else if (sequence.size() == 2 && sequence.get(sequence.size() - 1) < 0) {
                return false;
        } else {
            Collections.sort(sequence);
            Collections.reverse(sequence);
            if (sequence.get(0) >= 0){
                int firstNodeSize = sequence.get(0);
                sequence.remove(0);
                if (firstNodeSize > sequence.size()){
                    return false;
                }
                for(int i = 0; i < firstNodeSize; i++){
                    int newElementValue = sequence.get(i) - 1;
                    sequence.set(i, newElementValue);
                }
                return isGraphical(sequence);
            }
        }
        return true;
    }
}
