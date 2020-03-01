    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0, nums.length-1, nums);
    }

    public TreeNode build(int l, int r, int[] nums) {
        if (l > r)
            return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(l, mid - 1, nums);
        root.right = build(mid + 1, r, nums);
        return root;
    }