package a09_21_StreamsFilesDir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class p04ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {

        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathRead));

        PrintWriter printer = new PrintWriter( new FileOutputStream(pathWrite));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.println(scanner.next());
            }
            scanner.next();
        }

        printer.close();


    }
}
