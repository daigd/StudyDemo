package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.io.File;

/**
 * @Author DGD
 * @date 2018/3/10.
 */
public class FileSearch implements Runnable {
    private String nintPath;
    private String fileName;

    public FileSearch(String nintPath, String fileName) {
        this.nintPath = nintPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(nintPath);
        if (file.isDirectory()) {
            try {
                dictoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s : The search has been interrupted.",Thread.currentThread().getName());
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException{
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void dictoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    dictoryProcess(list[i]);
                }else{
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public String getNintPath() {
        return nintPath;
    }

    public void setNintPath(String nintPath) {
        this.nintPath = nintPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
