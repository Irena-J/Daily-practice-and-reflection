package SellTicket_Safe;

public class Sell_Ticket implements Runnable{
    //定义 50 张票
    private int ticket = 50;
    //创建锁对象
    private Object obj = new Object();
    public void run() {
        while (true) {
            synchronized(obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10 0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售" + (ticket--) + "票");
                }
            }
        }
    }
}
