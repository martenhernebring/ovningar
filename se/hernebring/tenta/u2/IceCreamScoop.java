package se.hernebring.tenta.u2;

public class IceCreamScoop{
    private String taste;
    private double weight;

    public IceCreamScoop(String taste, double weight){
        this.taste = taste;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Smak: %s, Vikt: %s.", taste, weight);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taste == null) ? 0 : taste.hashCode());
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
        IceCreamScoop other = (IceCreamScoop) obj;
        if (taste == null) {
            if (other.taste != null)
                return false;
        } else if (!taste.equals(other.taste))
            return false;
        return true;
    }

}
