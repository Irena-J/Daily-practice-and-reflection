package SellTicket_Movies_imp;
//以下的两个问题：出现相同的票、可能出现负数的票
//
public class SellTicket implements Runnable {
    private int ticket = 50;
    public void run() {
        while (true) {
            if (ticket > 0) {
                // 为了模拟更加真实的场景，每次出票后延迟 100 毫秒
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在出票"+(ticket--)+"票数");

           /* 出现相同的票(CPU的操作原子性决定的)
           * CPU 的每一次执行都是原子性(最简单基本)的操作，比如 ticket
           * 首先记录tiket以前的值 50
           * 接着执行 tiket-- 的操作
           * 然后输出以前的值 50    t1输出，就在这之间可能 t2 就来了，则 t2 也输出一样的了
           * tiket 的值变成 49
           */

           /*出现负数票的情况，就是在休眠的时候(随机性和延迟导致)
           * t1 、t2、t3 恰好都在 100 毫秒内分别进来了
           * 所以最坏情况下：
           * 正在出售第 1 张票 ticket = 0
           * 正在出售第 0 张票 tiket = -1
           * 正在出售第 -1 张票 tiket = -2
           */

            }
        }
    }
}
