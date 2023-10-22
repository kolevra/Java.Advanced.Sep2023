package a09_21_StreamsFilesDir;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class p02WriteToFile {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        FileInputStream inputStream = new FileInputStream(pathRead);

        FileOutputStream outputSteam = new FileOutputStream(pathWrite);

            int oneByte = inputStream.read();

            while (oneByte >= 0) {

            char symbol = (char) oneByte;

            if(!punctuation.contains(symbol)){

                outputSteam.write(symbol);

            }

            oneByte = inputStream.read();

            }

    }
}
