package vn.edu.likelion.assignment;

import java.io.File;

public class ThreadRemoveFile extends Thread{

    private File file;

    public ThreadRemoveFile(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        if (file.exists()){
            file.deleteOnExit();
            System.out.println("Delete file successfully!");
        }
    }
}
