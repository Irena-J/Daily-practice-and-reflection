package Product_Customer;

public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }
    public void run() {
        while (true) {
            synchronized (s) {
                // 判断有没有
                if (s.flag) {
                    try {
                        s.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(x % 2 == 0) {
                    s.name = "theshy";
                    s.age = 22;
                } else {
                    s.name = "rookie";
                    s.age = 23;
                }
                x++;

                // 修改标记
                s.flag= true;
                //唤醒线程
                s.notify(); //唤醒t2，此时唤醒并不代表立马执行，还要抢 CPU 执行权
            }
        }
    }
}
