package com.dgd.thread.java7concurrencycookbook.chapter2.arranging_independent_attributes_in_synchronized_classes;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class TicketOffice2 implements Runnable {
    private Cinema cinema;

    public TicketOffice2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets2(2);
        cinema.sellTickets2(4);
        cinema.sellTickets1(2);
        cinema.sellTickets1(1);
        cinema.returnTickets2(2);
        cinema.sellTickets1(2);
        cinema.sellTickets2(3);
        cinema.sellTickets1(2);
    }
}
