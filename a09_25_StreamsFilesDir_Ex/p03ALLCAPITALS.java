package a09_25_StreamsFilesDir_Ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class p03ALLCAPITALS {
    public static void main(String[] args) {


        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(pathRead));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(pathWrite))) {

            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
