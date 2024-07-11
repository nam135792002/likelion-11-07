package vn.edu.likelion.ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamApp {
    public static void main(String[] args) {
        // create path
        String fileName = "class3.txt";
        String content = "Hi Nam";

        // khoi tao doi tuong tu class FileOutputStream
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName);
            outputStream.write(content.getBytes());
            System.out.println("Da tao va ghi file thanh cong!");
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
