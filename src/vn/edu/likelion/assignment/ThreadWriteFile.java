package vn.edu.likelion.assignment;

import java.io.*;
import java.util.List;
import java.util.Timer;

public class ThreadWriteFile extends Thread{

    private File file;
    private BufferedWriter bufferedWriter;
    private List<StringBuffer> list;

    public ThreadWriteFile(File file, List<StringBuffer> list) {
        this.file = file;
        this.bufferedWriter = null;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < list.size(); i++){
                String s = String.valueOf(list.get(i));
                bufferedWriter.write(s);
                if(i < list.size() - 1){
                    bufferedWriter.write("\n");
                }

                if (i == 5){
                    System.out.println("Write file is lagging ...");
                    Thread.sleep(5000);
                }

                if(i == list.size() - 1){
                    System.out.println("Write file successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
