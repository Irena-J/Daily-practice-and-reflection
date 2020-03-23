package Product_Customer;

public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }
    public void run() {
        while (true) {
                if(x % 2 == 0) {
                   s.set("theshy",22);
                } else {
                    s.set("rookie",23);
                }
                x++;
        }
    }
}
