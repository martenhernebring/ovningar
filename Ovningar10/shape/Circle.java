package shape;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        super("circle");
        this.radius=radius;
    }
    
    @Override
    public String toString() {
        return String.format(super.toString()+"\t\tradius: %.2f",radius);
    }
}
