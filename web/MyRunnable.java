package lesson2;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            // getName是实例方法，必须通过对象来调用，所以必须获得当前线程
            System.out.println(Thread.currentThread().getName()+"x");
        }
    }
}
