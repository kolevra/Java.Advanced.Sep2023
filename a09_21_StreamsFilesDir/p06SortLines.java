package a09_21_StreamsFilesDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class p06SortLines {
    public static void main(String[] args) throws IOException {

        Path pathRead = Paths.get( "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";


        List<String> lines = Files.readAllLines(pathRead).stream()
                .sorted()
                .collect(Collectors.toList());

        Path outputPath = Paths.get(pathWrite);

        Files.write(outputPath, lines);

    }
}
