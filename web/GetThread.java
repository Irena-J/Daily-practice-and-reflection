package Product_Customer;

public class GetThread implements Runnable{
    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    public void run() {
        while (true) {
            synchronized (s) { // 锁上
                if(!s.flag) { // flag默认为false
                    try {
                        s.wait(); // t2等待，释放锁，将来醒过来也是从这里
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(s.name + "---"+s.age);
                // 修改标记
                s.flag = false;
                // 唤醒线程
                s.notify();
            }
        }
    }
}
