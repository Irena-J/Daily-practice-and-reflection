//冒泡排序，n表示数组大小
public void bubbleSort(int[] arr,int n) {
    if(n <= 1) {
        return;
    }
    for (int i = 0; i < n; i++) {            // 第 i 次的冒泡
        // 提前退出冒泡循环的标志位
        boolean flag = false;
        for (int j = 0; j < n-i-1; j++) {    // 第j号位置开始的比较
            if (arr[j] > arr[j+1]) {
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
                flag = true;
            }
        }
        if (flag == false) {
            break;
        }
    }
}