package se.hernebring.tenta.u2;

import javax.naming.SizeLimitExceededException;

public class App {
    public static void main(String[] args) throws SizeLimitExceededException {
        IceCream iceCream = new IceCream(Holder.BÄGARE);
        iceCream.addScoop(new IceCreamScoop("Choklad", 0.2));
        iceCream.addScoop(new IceCreamScoop("Kaffe", 0.3));
        iceCream.addScoop(new IceCreamScoop("Citron", 0.1));
        System.out.println(iceCream);
    }
}
