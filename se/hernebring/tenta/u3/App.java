package se.hernebring.tenta.u3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer("HP", 4, 400, 5000));
        computers.add(new Computer("Mac", 8, 1600, 3000));
        computers.add(new Computer("Iphone", 1, 3000, 1000));
        Collections.sort(computers);
        print(computers);
        var comparator = new HardDriveComparator();
        computers.sort(comparator);
        System.out.println();
        print(computers);
    }

    private static void print(List<Computer> computers) {
        for(Computer computer: computers){
            System.out.println(computer);
        }
    }
}
