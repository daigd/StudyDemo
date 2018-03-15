package com.dgd.thread.java7concurrencycookbook.chapter2.synchronizing_a_method;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class Client {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Bank bank = new Bank(account);
        Company company = new Company(account);

        System.out.printf("Account :　Initial balance : %f\n", account.getBalance());

        Thread bankThread = new Thread(bank);
        Thread companyThread = new Thread(company);

        bankThread.start();
        companyThread.start();

        try {
            bankThread.join();
            companyThread.join();

            System.out.printf("Account : Final balance :%f\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
