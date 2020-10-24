package se.hernebring.ovningar13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ovning3 {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("hello.txt"))){
            String str;
            while (true){
            str = br.readLine();
            if(str == null){
                break;
            }
            System.out.println(str);
            }
        } 
    }
}
