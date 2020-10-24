package se.hernebring.ovningar4;
public class Ovning4 {
    public static void main(String[] args) {
        boolean number=true;
        for(int i=1;i<=100;i++,number=true){
            if(i%3==0){
                System.out.print("Fizz");
                number=false;
            }
            if(i%5==0){
                System.out.print("Buzz");
                number=false;
            }
            if(number)
                System.out.println(""+i);
            else System.out.println();
        }
    }
}
