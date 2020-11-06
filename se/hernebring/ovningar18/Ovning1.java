package se.hernebring.ovningar18;

public class Ovning1<T> {
    private T value1;
    private T value2;

    public Ovning1(T v1, T v2) {
        value1 = v1;
        value2 = v2;
    }

    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
}
