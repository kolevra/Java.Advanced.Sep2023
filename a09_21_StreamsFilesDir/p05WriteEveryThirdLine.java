package a09_21_StreamsFilesDir;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class p05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(new FileInputStream(pathRead)));

        String line = reader.readLine();

        int counter = 1;

        List<String> lines = new ArrayList<>();

        while (line != null) {
            if (counter % 3 == 0) {
                lines.add(line);
            }
            counter++;
            line = reader.readLine();
        }

        Path pathObj = Paths.get(pathWrite);

        Files.write(pathObj, lines);


    }
}
