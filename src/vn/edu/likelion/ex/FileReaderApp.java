package vn.edu.likelion.ex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {
    public static void main(String[] args) {
        String sourceFile = "class4.txt";

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(sourceFile);
            int character;
            while((character = fileReader.read()) != -1){
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
