package a09_21_StreamsFilesDir;

import java.io.FileInputStream;
import java.io.IOException;

public class p01ReadFile {
    public static void main(String[] args) {

        //String dir = System.getProperty("dir");

        String path = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream inputStream = new FileInputStream(path)) {

            int oneByte = inputStream.read();

            while (oneByte >= 0) {

                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            System.out.println("File with path " + path + " was not found!");
        }

    }
}
