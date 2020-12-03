package se.hernebring.extra;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        // intializing an array arr1
        short[] arr1 = new short[] { 15, 10, 45, 25 };

        // printing the array
        System.out.println("Printing 1st array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // copying array arr1 to arr2 with range of index from 1 to 2
        short[] arr2 = Arrays.copyOfRange(arr1, 1, 2);

        // printing the array arr2
        System.out.println("Printing new array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
