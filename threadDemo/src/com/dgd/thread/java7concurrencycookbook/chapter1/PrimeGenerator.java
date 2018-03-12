package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/10.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is prime\n", number);
            }
            if (isInterrupted()) {
                System.out.printf("The prime generator has been iterrupted.");
                return;
            }
            number++;

        }

    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2;i < number;i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
