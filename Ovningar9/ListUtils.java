import java.util.ArrayList;
import java.util.List;

// make InsertionSort reusable by introducing utility class
public class ListUtils {
    public static List<Integer> insertionSort(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (newList.isEmpty()) {
                newList.add(number);
                System.out.print("isEmpty: " + number + "\t");
            } else {
                for (int i = 0; i < newList.size(); i++) {
                    Integer current = newList.get(i);
                    if (current > number) {
                        newList.add(i, number);
                        System.out.println(newList);
                        break;
                    }
                }
            }
        }
        System.out.println("");
        return newList;
    }
}
