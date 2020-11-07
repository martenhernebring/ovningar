package se.hernebring.ovningar18;

public class Ovning6 {

    public static void main(String[] args) {
        Character ch1 = '3';
        Character ch2 = '3';
        Character ch3 = '3';
        if(allSame(ch1, ch2, ch3)){
            System.out.println("They are all the same");
        }
    }

    public static <T extends Comparable<T>> boolean allSame(T ob1, T ob2, T ob3) {
        // all null
        if (ob1 == null && ob2 == null && ob3 == null) {
            return true;
        }

        // some null
        if (ob1 == null || ob2 == null || ob3 == null) {
            return false;
        }

        return ob1.compareTo(ob2) == 0 && ob2.compareTo(ob3) == 0;
    }
}
