package se.hernebring.repetition3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyReverseLowCase {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage CopyReverseLowCase [file name]");
            System.exit(-1);
        }
        Path path = null;
        try {
            path = checkIfFileExist(args[0]);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        makeCopy(path);
    }

	private static Path checkIfFileExist(String file) throws FileNotFoundException {
        Path path = Path.of(file);
        if(Files.exists(path)){
            return path;
        } else{
            throw new FileNotFoundException(String.format("%s does not exist.%n", file));
        }
    }

    private static void makeCopy(Path path) {
        Path out = Path.of(path.getFileName()+".crlc");
        try(BufferedReader reader = Files.newBufferedReader(path);
            BufferedWriter writer = Files.newBufferedWriter(out, StandardCharsets.UTF_8)){
                while(true){
                    String line = reader.readLine();
                    if(line == null){
                        break;
                    }
                    StringBuilder builder = new StringBuilder(line.toLowerCase());
                    String reverseLowCase = builder.reverse().toString();
                    writer.write(reverseLowCase);
                    writer.newLine();
                }
        } catch(IOException ex){
            System.err.println("Problems reading file");
        }
	}
}
