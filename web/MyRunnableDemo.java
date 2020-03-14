package lesson2;
import java.lang.Thread;
/*方式2：实现Runnable接口
* 步骤：
*   A 自定义类MyRunnable实现Runnable接口
*   B 重写run() 方法
*   C 创建MyRunnable类的对象
*   D 创建Thread类的对象，并把C步骤的对象作为参数传递
*/
public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();

        /*Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);
        t1.setName("阿泽");
        t1.setName("正焕");
        t1.start();
        t2.start();*/
        Thread t1 = new Thread(my,"阿泽");
        Thread t2 = new Thread(my,"正焕");

        t1.start();
        t2.start();
    }

}
