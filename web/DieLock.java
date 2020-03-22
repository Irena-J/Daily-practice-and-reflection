package Die_Lock;

class DieLock extends Thread {
    private boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (MyLock.objA) { //注意当执行的这里，可能会被下面这个锁
                System.out.println("if objA");
                synchronized (MyLock.objB) {
                }
            }
        } else {
            synchronized (MyLock.objB) {
                System.out.println("else objB");
                synchronized (MyLock.objA) {
                    System.out.println("else objA");
                }
            }
        }
    }
}
