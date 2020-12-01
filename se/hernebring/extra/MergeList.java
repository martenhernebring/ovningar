package se.hernebring.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.hernebring.utils.ListUtils;

public class MergeList {
    public static void main(String[] args) {
        List<String> datum = new ArrayList<>(Arrays.asList(
            "1966-02-24", "1996-12-05", "1927-09-27", 
            "1927-01-30", "1935-03-14", "1867-11-07"));
        List<String> namn = new ArrayList<>(Arrays.asList(
            "Tina", "Hampus", "Grazia", "Olof", "Per Christian", "Maria"));
        List<String> datum_namn = ListUtils.join(datum, namn, 
            (left, right) -> left + " " + right);
        for(String person: datum_namn){
            System.out.println(person);
        }
    }
}
