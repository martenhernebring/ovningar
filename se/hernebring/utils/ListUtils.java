package se.hernebring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ListUtils {

    public static <T, U, R> List<R> join(List<T> list1, List<U> list2, BiFunction<T, U, R> func) {
        List<R> result = new ArrayList<>();
        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            result.add(func.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    public static List<Integer> insertionSort(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (newList.isEmpty()) {
                newList.add(number);
                System.out.print("isEmpty: " + number + "\t");
            } else {
                for (int i = 0; i < newList.size(); i++) {
                    Integer current = newList.get(i);
                    if (current > number) {
                        newList.add(i, number);
                        System.out.println(newList);
                        break;
                    }
                }
            }
        }
        System.out.println("");
        return newList;
    }

}
