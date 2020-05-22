
import java.util.*;

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        // 二叉查找树以右上角为根结点的层序遍历
        int[] res = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n){
            int x = startX;
            int y = startY;
            while(x<n&&y<n)
                res[index++]=arr[x++][y++];
            if(startY>0)
                startY--;
            else
                startX++;
        }
        return res;
    }
}



