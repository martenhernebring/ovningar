package se.hernebring.ovningar18;

public class PairDemo {
    public static void main(String[] args) {
        Ovning1<Integer> ovning1 = new Ovning1<Integer>(10, 5);
        System.out.println(ovning1.getValue1() +" "+ovning1.getValue2());

        Pair<String> pair = new Pair<String>("alfa", "beta");
        Pair<String> pair2 = new Pair<String>("alfa", "beta");
        Pair<String> pair3 = new Pair<String>("Alfa", "beta");
        if(pair.equals(pair2)){
            System.out.println("pair och pair2 är samma");
        }
        if(pair.compareTo(pair3) == 0){
            System.out.println("pair och pair3 är samma");
        }
    }
}
