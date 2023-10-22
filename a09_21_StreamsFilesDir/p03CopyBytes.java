package a09_21_StreamsFilesDir;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p03CopyBytes {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_21_StreamsFilesDir\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";


        FileInputStream inputStream = new FileInputStream(pathRead);

        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 10) {         // 13
                outputStream.write('\n');
                //} else if(oneByte !=10){
            } else {


                String message = String.valueOf(oneByte);

                for (char c : message.toCharArray()) {
                    outputStream.write(c);
                }

            }

            oneByte = inputStream.read();
        }

    }
}
