// 插入排序，n表示数组大小
public void insertionSort(int[] arr, int n) {
    if (n < 1) {
        return;
    }
    
    for (int i = 1; i < n; i++) {
        // value 待插入的数
        int value = arr[i];
        // 插入的位置当然是从 i 前开始啦
        int j = i - 1;
        // 查找插入的位置
        for (; j >= 0; j--) {
            if (arr[j] > value) {
                arr[j+1] = arr[j]; // 数据移动
            } else {
                break;
            }
        } 
        a[j+1] = value;    // 插入元素
    }
}