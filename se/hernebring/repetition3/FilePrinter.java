package se.hernebring.repetition3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilePrinter {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage FilePrinter file1 file2 ....");
            System.exit(-1);
        }
        List<FileInfo> fileInfos = createFileList(args);
        printFileList(fileInfos);
    }

    private static void printFileList(List<FileInfo> fileInfos) {
        Collections.sort(fileInfos);
        for(FileInfo fileInfo : fileInfos){
            System.out.println(fileInfo);
        }
    }

    private static List<FileInfo> createFileList(String[] files) {
        int numberOfFiles = files.length;
        List<FileInfo> fileInfo = new ArrayList<>(numberOfFiles);
        for(String file: files){
            try {
                long byteSize = Files.size(Path.of(file));
                fileInfo.add(new FileInfo(file, byteSize));
            } catch (IOException e) {
                System.err.printf("%s did not exist.%n", file);
            }
        }
        return fileInfo;
    }
}
