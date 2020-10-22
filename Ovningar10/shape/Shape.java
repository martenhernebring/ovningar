package shape;
public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
