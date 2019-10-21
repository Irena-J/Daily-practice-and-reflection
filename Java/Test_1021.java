// 1 数组遍历的两种方式
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
public class Test_1020{
    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,5,6};
        //int[] newarr = Arrays.copyOf(arr1,arr1.length);
        //System.out.println(Arrays.toString(newarr));
        //System.out.println(binarySearch( 0,6,arr1,6));
        //System.out.println(binarySearch1(arr1,6));
        //printArr(arr1);
        //printArr(arr1);
        //transform(arr1);
       //System.out.println(toString1(arr1));
        //System.out.println(aveSum(arr1));
        //turnArr(arr1);
        Sweap(arr1);
       // System.out.println(Arrays.toString(arr1));
    }
    public static void printArr(int[] arr1){
        for (int i = 0; i <arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
    public static void printArr1(int[] arr1){
        for (int x:arr1) {
            System.out.println(x);
        }
    }
    public static void transform(int[] arr1){
        int[] arr2 = new int [arr1.length];
        for(int x:arr2){
            x*=2;
            System.out.println(x);
        }
    }
    public static String toString1(int[] arr1){
        String ret ="[";
        int i=0;
        for(;i<arr1.length;i++){
            ret+=arr1[i];
            if(i!=arr1.length-1) {
                ret += ",";
            }
        }
        ret+="]";
        return ret;
    }
    public static int findMax(int[] arr1){
        int max = arr1[0];
        for (int i = 0; i <arr1.length ; i++) {
            if(max<arr1[i]){
                max=arr1[i];
            }
        }
        return max;
    }
    public static double aveSum(int[] arr1){
        int sum = 0;
        for(int i=0;i<arr1.length;i++){
            sum+=arr1[i];
        }
        return (double)sum/arr1.length;
    }
   public static int binarySearch1(int[] arr1,int key) {
    int left = 0;
    int right = arr1.length;
    while(left<right){
        int mid = (left+right)/2;
        if(key>arr1[mid]){
            left=mid+1;
        }else if(key<arr1[mid]){
            right=mid-1;
        }else{
            return mid;
        }
    }
       return -1;
   }
   //传参数的时候一定要注意，别忘记了left代表的是首元素下表，right代表了数组长度
   public static int binarySearch(int left,int right,int[] arr1,int key) {
        int mid =(left+right)/2;
        if(key==arr1[mid]){
            return mid;
        }if(key>arr1[mid]){
            return binarySearch(mid,right,arr1,key);
       }if(key<arr1[mid]){
            return binarySearch(left,mid,arr1,key);
       }
       return -1;
   }
   public static void turnArr(int[] arr1){
       int left = 0;
       int right = arr1.length-1;
       int index=0;
       while(left<right) {
               index = arr1[left];
               arr1[left] = arr1[right];
               arr1[right] = index;
               left++;
               right--;;
           }
   }
   public static void Sweap(int[] arr) {
       int left = 0;
       int right = arr.length - 1;
       while (left < right) {
           while (left < right && arr[left] % 2 == 0) {
               left++;
           }
           while (left < right && arr[left] % 2 != 0) {
               right--;
           }
           int index = arr[left];
           arr[left] = arr[right];
           arr[right] = index;
       }
       System.out.println(Arrays.toString(arr));
   }
//public static void Sweap1 ( int[] arr){
//    int left = 0;
//    int right = arr.length - 1;
//    while (left < right) {
//        while (left < right && arr[left] % 2 == 0) {
//            left++;
//        }
//        while (left < right && arr[right] % 2 != 0) {
//            right--;
//        }
//        int index = arr[left];
//        arr[left] = arr[right];
//        arr[right] = index;
//    }
//    System.out.println(Arrays.toString(arr));
//
//}
}