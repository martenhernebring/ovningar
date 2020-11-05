package se.hernebring.ovningar16;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(Integer.valueOf(0));
        objects.add(new ArrayList<Object>());
        objects.add(new int[10]);
        objects.add(objects.getClass());
        for (Object o : objects) {
            System.out.println(o.getClass().getSimpleName());
            System.out.println(o.getClass().getName());
            System.out.println(o.getClass().getCanonicalName());
            System.out.println("");
        }
    }
}