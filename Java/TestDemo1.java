public class TestDemo1 {
    public static void main(String[] args){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(1,4);
        myArrayList.add(0,5);
        myArrayList.display();//5 3 4 2 1

        myArrayList.remove(5);
        myArrayList.display();
        myArrayList.remove(1);
        myArrayList.display();
        myArrayList.remove(4);
        myArrayList.display();
        System.out.println("======================");
        myArrayList.clear();
        myArrayList.display();
    }
}
