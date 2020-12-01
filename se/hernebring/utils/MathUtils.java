package se.hernebring.utils;

import java.util.ArrayList;
import java.util.List;

public final class MathUtils {
    static int lowestPositive(List<Integer> integers) {
        int lowestPositive = Integer.MAX_VALUE; // no positive values
        for (Integer intgr : integers) {
            if (intgr > 0 && intgr < lowestPositive) {
                lowestPositive = intgr;
            }
        }
        return lowestPositive;
    }

    static int digitSum(List<Integer> integers) {
        int sum = 0; // disregard positive and negative numbers
        for (Integer intgr : integers) {
            for (int i = 1_000_000_000; i > 0; i /= 10) {
                sum += intgr / i;
                intgr = intgr % i;
            }
        }
        return sum;
    }

    static List<Integer> getNegatives(List<Integer> integers){
        List<Integer> negatives = new ArrayList<>();
        for(Integer ntgr: integers){
            if(ntgr<0){
                negatives.add(ntgr);
            }
        }
        return negatives;
    }
}
