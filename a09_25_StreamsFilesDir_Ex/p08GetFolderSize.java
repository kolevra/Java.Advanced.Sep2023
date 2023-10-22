package a09_25_StreamsFilesDir_Ex;

import java.io.File;

public class p08GetFolderSize {
    public static void main(String[] args) {

        String path = "D:\\SoftUni\\03.Advanced\\JavaAdvanced_09.23\\Advanced\\src\\a09_25_StreamsFilesDir_Ex\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);
        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    size += file.length();
                }
            }
        }
        System.out.printf("Folder size: %d", size);


    }
}
