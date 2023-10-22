package a09_25_StreamsFilesDir_Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p01SumLines {
    public static void main(String[] args) {

        String path = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {

                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
