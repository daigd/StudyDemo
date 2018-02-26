package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class Piped {
    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输入流输出流连接
        out.connect(in);

        new Thread(new Print(in), "PrintThread").start();

        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (Exception e) {

            }
        }
    }

}
