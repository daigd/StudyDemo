package com.dgd.thread.java7concurrencycookbook.chapter2.synchronizing_a_method;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }
}
