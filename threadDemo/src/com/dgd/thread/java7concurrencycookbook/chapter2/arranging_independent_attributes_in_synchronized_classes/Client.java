package com.dgd.thread.java7concurrencycookbook.chapter2.arranging_independent_attributes_in_synchronized_classes;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class Client {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Thread thread1 = new Thread(new TicketOffice1(cinema), "TicketOffice1");
        Thread thread2 = new Thread(new TicketOffice2(cinema), "TicketOffice2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 vacancies : %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 vacancies : %d\n", cinema.getVacanciesCinema2());

    }
}
