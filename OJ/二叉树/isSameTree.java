检验两颗二叉树是否相同
public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果是两棵空树
        if(p == null && q == null) {
            return true;
        }
        //如果两棵树中至少由一棵树是空树
        if(p == null || q == null) {
            return false;
        }
        //如果两颗树的值域不相同
        if(p.val != q.val) {
            return false;
        }
        //通过判断左右子树来判别是否相同
        return isSameTree(p.left,q.left) && 
        isSameTree(p.right,q.right); 
    }   