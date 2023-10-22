package a09_25_StreamsFilesDir_Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class p05LineNumbers {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintWriter print = new PrintWriter("D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        int lineCount = 1;
        String line = reader.readLine();
        while (line != null) {
            line = String.format("%d. %s", lineCount, line);
            print.println(line);

            line = reader.readLine();
            lineCount++;
        }

        reader.close();
        print.close();


    }
}
