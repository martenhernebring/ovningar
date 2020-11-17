package se.hernebring.ovningar23;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class UTF16Test {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter bw = Files.newBufferedWriter(Path.of("u8fil.txt"), StandardCharsets.UTF_8)){
            bw.write("\u2661\u2665\u2661");
        }
        //System.out.println("\u2661\u2665\u2661");
    }
}
