import java.util.Arrays;
public class Test_1019 {
    public static void main(String[] args){
       int [] arr={1,2,3};
       int [] array={1,2,3,4,5,6,7};
       int left=1;
       int right=7;
       System.out.println(binarySearch(array,3,1,7));
       //printArr(arr);
        //printArr3(arr);
       // transForm1(arr);
        //transForm2(arr);
        //printArr4(arr);
        //System.out.println(toString(arr));
        //printTurn(arr);
        //turnArr(arr);
        Sweap(arr);
    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void printArr2(int[] arr){
        for(int x:arr){
            System.out.println(x);
        }
    }
    public static void funChange(int[] arr){
        arr[0]=10;
        System.out.println(arr[0]);
    }
    public static void printArr3(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void transForm1(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*2;
            System.out.println(arr[i]);
        }

        //System.out.println(arr[i]);
    }
    public static void transForm2(int[] arr){
        int [] arr2= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i]=arr[i]*2;
            System.out.println(arr2[i]);
        }
    }
   public static void printArr4(int[] arr){
         String arr3 = Arrays.toString(arr);
         System.out.println(arr3);
   }
   public static String toString1(int[] arr){
        String arr2 ="[";
        for(int i=0;i<arr.length;i++){
            arr2 += arr[i];
            if(i!=arr.length-1){
                arr2 += ",";
            }
        }
        arr2 += "]";
        return arr2;
   }
   public static String toString(int[]arr){
       String arr2 = "[";       //时刻记住字符串类型也是一个引用类型，同样是在堆上创建对象
        for(int i=0;i<arr.length;i++){
            arr2+=arr[i];   //字符串加整型，最后的结果还是一个字符串
            if(i==(arr.length-1)){
                break;
            }
            arr2+=",";  //有时候认为你生成的对象太多了就会报一个warning
        }
        arr2 +="]";
        return arr2;
   }
   public static int maxNum(int[] arr){
        int max=arr[0];
       for (int i = 0; i <arr.length ; i++) {
           if(max<arr[i]){
               max=arr[i];
           }
       }
      return max;
   }
   public static int minNum(int[] arr){
        int min=arr[0];
       for (int i = 0; i <arr.length ; i++) {
           if(min<arr[i]){
               min=arr[i];
           }
       }
       return min;
   }
   public static int aveArr(int[] arr){
        int sum=0;
        int i=0;
       for (; i <arr.length ; i++) {
         sum+=arr[i];
       }
      return sum/arr.length;
   }
   public static void printTurn(int[] arr){
       int last=0;
       int first=0;
       int index=0;
        for (int i = 0; i <arr.length ; i++) {
           index = arr[arr.length-1];
           last=arr[0];
           first=index;
           first++;
           last--;
           System.out.println(arr[i]);
       }
   }
   public static void turnArr(int[] arr){
        int first=0;
        int last=arr.length-1;
        int index=0;

                while(first<last){
                    index = arr[arr.length-1];
                    arr[last]=arr[first];
                    arr[first]=index;
                    first++;
                    last--;
                }
                System.out.println(toString(arr));
   }
   public static void Sweap(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while (left < right && arr[left]%2==0) {
                left++;
            }
            while(left<right && arr[right]%2!=0 ){
                right--;
            }
            int index=arr[left];
            arr[left]=arr[right];
            arr[right]=index;
        }
        System.out.println(toString(arr));
   }
   public static int binarySearch(int[] array,int key,int left,int right){
        if(left>right){
            return -1;
        }
       int mid=(left+right)/2;
       if(key==array[mid]) {
           return mid;
       }else if(key<array[mid]){
           return binarySearch(array,mid,left,mid-1);
        }else(key>array[mid]){
          return binarySearch(array,mid,right,mid+1);
       }
   }






}

