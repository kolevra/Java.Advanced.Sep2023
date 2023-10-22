package a09_25_StreamsFilesDir_Ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class p04CountCharacterTypes {
    public static void main(String[] args) {

        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');
        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(pathRead));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(pathWrite))) {

            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuation.contains(symbol)) {
                        punctuationsCount++;
                    } else if (symbol != ' ') {
                        othersCount++;
                    }
                }
                line = reader.readLine();
            }
            System.out.println();
            writer.write(String.format("Vowels: %d\n", vowelsCount));
            writer.write(String.format("Other symbols: %d\n", othersCount));
            writer.write(String.format("Punctuation: %d", punctuationsCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
