class Solution {
    public void rotate(int[] nums, int k) {
        int index = nums.length-1;
            k = k % nums.length;
        for(int i = 0;i < k;i++) {
            int tmp = nums[index];
            for(int j = index;j > 0;j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }
}