package se.hernebring.ovningar10.shape;
public class Triangle extends Shape {
    private double height, width;

    public Triangle(double height, double width) {
        super("triangle");
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format(super.toString()+"\twidth: %.2f\theight: %.2f\t",width,height);
    }

}
