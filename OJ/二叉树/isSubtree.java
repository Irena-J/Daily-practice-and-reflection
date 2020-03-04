public boolean isSubtree(TreeNode s, TreeNode t) {
       
        //一定注意，题设中说是非空二叉树，
        //但是这里千万不要忽略了递归的终止条件，我们不能忽略了子树的情况
        if(t == null ){
            return true;
        }
        //约定空树是任意一棵二叉树的子树，注意包含的情况
        if(s == null) {
            return false;
        }

        // if(s == null && t == null) {
        //     return true;
        // }
        // //这里就默认空树不是任意一棵二叉树的子树
        // if(s == null || t == null) {
        //     return false;
        // }
        
        //两棵二叉树相同的情况不考虑
        if((s.val == t.val) && isSameTree(s,t)) {
            return true;
        }
        //t 是 s 的子树
        //上面已经提高效率，在判断子树相同的时候就可以避免根节点相同的情况了
            return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean isSameTree(TreeNode s,TreeNode t) {
        if(s== null && t == null){
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }