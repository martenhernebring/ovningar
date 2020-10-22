package shape;
import java.util.ArrayList;
import java.util.List;

public class Ovning2 {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle(3.14));
        shapeList.add(new Circle(1.23));
        shapeList.add(new Triangle(2.5,1));
        shapeList.add(new Triangle(3.33,2));

        for(Shape shape : shapeList){
            System.out.println(shape);
        }
    }
}
