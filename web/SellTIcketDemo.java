package SellTicket_Movies_imp;

public class SellTIcketDemo {
    public static void main(String[] args) {
        //创建线程资源对象
        SellTicket s = new SellTicket();
        //创建三个线程对象
        Thread t1 = new Thread(s,"窗口1");
        Thread t2 = new Thread(s,"窗口2");
        Thread t3 = new Thread(s,"窗口3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
