package se.hernebring.ovningar18;

import java.util.ArrayList;
import java.util.List;

public class Ovning4 {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(3);
        set.add(3);
        set.add(2);

        if(oddItems(set)){
            System.out.println("Has odd number");
        }
    }

    public static boolean oddItems(List<?> list){
        return list.size() % 2 == 1;
    }
}
