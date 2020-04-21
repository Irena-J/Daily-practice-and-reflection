import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        // 先暴力，数组中的每一个数分别与每个数比较，出现次数大于n/2的返回;可优化时间
        /*Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!s.add(gifts[i])) {
                int count = 1;
                for (int j = i; j < n; j++) {
                    if (gifts[j] == gifts[i]) {
                        count++;
                    }
                    if (count > (n>>1)) {
                        return gifts[j];
                    }
                }
            }
        }
       return 0;*/
        // 方式二：先排序，如果这个数存在，那么中间的那个一定就是重复出现的，n大于一半众数等于中位数
        /*Arrays.sort(gifts);
        int tmp = gifts[n/2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] == tmp) {
                count++;
            }
        }
        return count > (n>>1) ? tmp : 0;*/

        // 方式三：遍历数组保存数组中每个数字出现的次数，当比哪里到下一个数字的时候，
        // 如果下一个数字和之前保存的数字相同，则次数加一不同则减一，如果为0就保存下一个数，
        // 并把次数设为1.由于要找的数字出现次数大于n/，最后要找的数字是最后一次把次数设置为1的数字
        
        int count = 1;
        int tmp = gifts[0];
        for (int i = 1; i < n; ++i) {
            if (gifts[i] != tmp) {
                count--;
                if (count == 0) {
                    tmp = gifts[i];
                }
            } else {
                count++;
            }
        }
        if (count > 0) {
            return tmp;
        }
       return 0;
    }
}