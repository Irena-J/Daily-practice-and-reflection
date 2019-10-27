import java.util.Arrays;
public class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList(){
        this.usedSize=0;
        this.elem = new int[CAPACITY];
    }
    private boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    //在pos位置新增元素
    public void add(int pos,int data){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length);
        }
        //1、pos是否合法
        if(pos<0 || pos>this.usedSize){
            throw new IndexOutOfBoundsException("pos位置不合法");
    }
        //2、挪数据
        for(int i = this.usedSize-1;i>=pos;i--){
            this.elem[i+1]=this.elem[i];
        }
        //3、插入数据
        this.elem[pos] = data;
        //4、uesdSize++
        this.usedSize++;
    }
    public boolean contains(int toFind){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        if(isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        for(int i =0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos){
        if(pos<0||pos>this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为value
    //public void setPos(int pos,int value)
    private boolean isEmpty(){
       return this.usedSize==0;
    }
    //删除第一次出现的关键字toRemove
    public void remove(int toRemove){
        //1、查找toRemove的下标
        int index = search(toRemove);
        if(index==-1){
            System.out.println("没有你要删除的数字！");
            return;
        }
        //2、删除
        for(int i = index;i<this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //清空顺序表
    public void clear(){
        this.usedSize=0;
    }
    //打印顺序表
    public void display(){
        for(int i=0;i<this.usedSize;i++){
           System.out.print(this.elem[i]+"");
        }
        System.out.println();
    }
}
