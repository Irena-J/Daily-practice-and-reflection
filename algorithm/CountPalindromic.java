import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        // 计数器
        int count = 0;
        // 循环将插入到 A 的不同位置 
        for (int i = 0; i <= A.length(); i++) {
            // 先将 A 转成 StringBuffer 进行 insert 操作
            StringBuffer newA = new StringBuffer(A);
            newA.insert(i, B);
            // 判断 newA 为回文串 count++
            if(isPalindromic(newA.toString())) {
                count++;
            }
        }
        System.out.print(count);
    }
    
    // 判断是否为回文数
    private static boolean isPalindromic (String str) {
        int i = 0;
        int j = str.length() - 1;
        // 两个指针
        // 一个从前向后 一个从后向前 
        // 遍历char 发现不同返回 false
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        // 遍历结束返回 true
        return true;
    }
}
