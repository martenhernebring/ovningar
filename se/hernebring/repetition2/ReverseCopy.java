package se.hernebring.repetition2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*Original CopyFileWithBuffer io */
public class ReverseCopy {
    public static void main(String[] args) throws IOException{
        final String usage = "Usage Ovning6 file reverse_copy";
        if(args == null){
            System.out.println(usage);
            System.exit(-1);
        }
        if (args.length != 2) {
            System.out.println(usage);
            System.exit(-1);
        }

        Path theFile = FileSystems.getDefault().getPath(args[0]);
        if (!Files.exists(theFile)) {
            System.out.println("Filen finns inte.");
            System.exit(-1);
        }

        StringBuilder textToBeReversed = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            long pre = System.currentTimeMillis();
            while ((line = reader.readLine()) != null) {
	            textToBeReversed.append(line);
	            textToBeReversed.append(ls);
            }   
            long after = System.currentTimeMillis();
            System.out.println(after-pre+" millisekunder tog läsning.");
        }
        // delete the last new line separator
        textToBeReversed.deleteCharAt(textToBeReversed.length() - 1);
        String reversedText = textToBeReversed.reverse().toString();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            long pre = System.currentTimeMillis();
            writer.write(reversedText,0,reversedText.length());
            long after = System.currentTimeMillis();
            System.out.println(after-pre+" millisekunder tog skrivning.");
        }
    }

}
