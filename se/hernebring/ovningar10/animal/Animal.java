package se.hernebring.ovningar10.animal;

public abstract class Animal {
    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
