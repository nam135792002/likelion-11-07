package vn.edu.likelion.ex;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamApp {
    public static void main(String[] args){
        // duong dan va ten file
        // neu ko cos duong dan thi se tim ben ngoai project
        // neu file nay ko ton tai thi se bao loi FileNotFoundException
        String sourceFile = "class3.txt";

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(sourceFile);
            byte[] content = new byte[1024];
            int byteRead;

            // ghi noi dung trong file ra man hinh console
            while ((byteRead = fileInputStream.read(content)) != -1){
                System.out.println(new String(content, 0, byteRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
