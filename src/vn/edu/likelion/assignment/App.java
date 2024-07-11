package vn.edu.likelion.assignment;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // create object file with name file read.
        File fileRead = new File("StudentsList.txt");

        // user enter the name file write.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name which saving into db: ");
        String name = sc.nextLine();
        name += ".txt";

        // create object file with name file write.
        File fileWrite = new File(name);

        // create object bufferedReader with null
        BufferedReader bufferedReader = null;

        // create list to save info from file read StudentList.txt
        List<StringBuffer> listInfo = new LinkedList<>();

        // copy db from StudentList to listInfo
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileRead));

            while ((line = bufferedReader.readLine()) != null){
                listInfo.add(new StringBuffer(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ThreadWriteFile threadWriteFile = new ThreadWriteFile(fileWrite, listInfo);
        ThreadRemoveFile threadRemoveFile = new ThreadRemoveFile(fileRead);

        threadWriteFile.start();
        threadRemoveFile.start();

    }
}
