public class TestDemo2 {
    public static  void main(String[] args){
        MySignalList mySignalList = new MySignalList();
        mySignalList.addLast(1);
        mySignalList.addLast(2);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
        mySignalList.display();
        mySignalList.addIndex(0,19);
        mySignalList.display();
        mySignalList.addIndex(5,29);
        mySignalList.display();
        mySignalList.addIndex(1,99);
    }
}
