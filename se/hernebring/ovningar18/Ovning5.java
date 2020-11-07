package se.hernebring.ovningar18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ovning5 {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(3);
        set.add(3);
        set.add(2);

        List<String> unique = new LinkedList<>();
        unique.add("alfa");
        unique.add("beta");
        unique.add("gamma");

        if (onlyUnique(set)) {
            System.out.println("Set has unique items");
        }

        if (onlyUnique(unique)) {
            System.out.println("Unique has unique items");
        }
    }

    public static boolean onlyUnique(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
