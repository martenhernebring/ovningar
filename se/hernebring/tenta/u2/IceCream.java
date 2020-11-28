package se.hernebring.tenta.u2;

import java.util.ArrayList;
import java.util.List;

public class IceCream {
    private Holder holder;
    private List<IceCreamScoop> scoops;
    private int size;

    public IceCream(Holder holder){
        this.holder = holder;
        scoops = new ArrayList<>();
    }

    public void addScoop(IceCreamScoop scoop) throws TooManyScoopsException {
        if(size > 4){
            throw new TooManyScoopsException("För många kulor glass");
        }
        scoops.add(scoop);
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hållare: %s%n", holder));
        int i = 0;
        for(IceCreamScoop scoop: scoops){
            i++;
            builder.append(String.format("Kula%s (%s)%n", i, scoop));
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((holder == null) ? 0 : holder.hashCode());
        result = prime * result + ((scoops == null) ? 0 : scoops.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IceCream other = (IceCream) obj;
        if (holder != other.holder)
            return false;
        if (scoops == null) {
            if (other.scoops != null)
                return false;
        } else if (!scoops.equals(other.scoops))
            return false;
        return true;
    }
    
}
