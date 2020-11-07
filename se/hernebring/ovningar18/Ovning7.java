package se.hernebring.ovningar18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ovning7 {

    public static void main(String[] args) {
        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(5);
        unsorted.add(1);
        unsorted.add(7);
        unsorted.add(3);
        unsorted.add(6);

        if(isSorted(unsorted)){
            System.out.println("Unsorted is sorted");
        }

        Collections.sort(unsorted);
        if(isSorted(unsorted)){
            System.out.println("Sorted is sorted");
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(List<?> values) {
        for (int i = 0; i < values.size() - 1; ++i) {
            @SuppressWarnings("unchecked")
            T current = (T) values.get(i);
            @SuppressWarnings("unchecked")
            T next = (T) values.get(i + 1);
            // current must be less or equal to the next element for things
            // to be in order
            if (current.compareTo(next) > 0) {
                return false;
            }
        }
        return true;
    }
}
