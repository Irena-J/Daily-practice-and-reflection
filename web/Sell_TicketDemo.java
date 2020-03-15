package SellTicket_Safe;

public class Sell_TicketDemo {
    public static void main(String[] args) {
        //创建资源对象
        Sell_Ticket my = new Sell_Ticket();
        //创建线程对象
        Thread t1 = new Thread(my,"窗口1");
        Thread t2 = new Thread(my,"窗口2");
        Thread t3 = new Thread(my,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
