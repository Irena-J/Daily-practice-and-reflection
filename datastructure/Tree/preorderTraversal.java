/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
         // 需要注意返回值类型，所以必须要先 new 出来
         List<Integer> li = new LinkedList<Integer>();
        // 如果是一棵空树
        if (root == null) {
            return li;
        }
        // 树非空，有两种方式，都需要借助栈或者集合中维护的堆栈
        // 方式一；将节点以右子树左子树的方式入栈
    
       
        Stack<TreeNode> s = new Stack<TreeNode>();

        s.push(root);
        while(!s.isEmpty()) {
            // 注意这个变量是不可省的，后面要通过他判断左右子树
            TreeNode cur = s.peek();
            li.add(cur.val);
            s.pop();
            // 一定不要忘记出栈哦，因为你注意循环条件
        
            // 如果右子树不为空，右子树入栈
            if(cur.right != null) {
                s.push(cur.right);
            }
            // 如果左子树不为空，右子树入栈
            if(cur.left != null) {
                s.push(cur.left);
            }
        }
        return li;
    }
}