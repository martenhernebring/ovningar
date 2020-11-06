package se.hernebring.ovningar18;

import java.util.Comparator;
import java.util.Objects;

public class Pair<T extends Comparable<T>> implements Comparable<Pair<T>> {
    private T value1;
    private T value2;

    public Pair(T v1, T v2) {
        value1 = v1;
        value2 = v2;
    }

    public T getValueOne() {
        return value1;
    }

    public T getValueTwo() {
        return value2;
    }

    @Override
    public int hashCode() {
        final var prime = 31;
        var result = 1;
        result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
        result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair<?> otherPair = (Pair<?>) obj;
        return Objects.equals(value1, otherPair.value1) && Objects.equals(value2, otherPair.value2);
    }

    @Override
    public int compareTo(Pair<T> obj) {
        Comparator<T> comp = Comparator.nullsFirst(Comparator.naturalOrder());
        var res = comp.compare(value1, obj.value1);
        if (res != 0) {
            return res;
        }
        return comp.compare(value2, obj.value2);
    }
}