package se.hernebring.ovningar13;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ovning1 {
    public static void main(String[] args) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt"))){
            bw.write("Hello World\n");
        }
    }
}