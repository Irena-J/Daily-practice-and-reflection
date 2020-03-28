中序非递归遍历

做法：

```
1、先找到以 root 为根的二叉树中最左侧的节点，并保存所经过的路径中所有节点
2、cur 为空---认为 cur对应的树已经遍历(获取栈顶元素，因为此时的栈顶的元素的左子树一定为null，可以认	 为左子树已经遍历结束，此时就剋遍历当前根结点，也就是最左子树)
3、遍历当前栈顶 cur 的右子树

```

```
public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> li = new LinkedList<Integer>();
	LinkedList<TreeNode> sn = new LinkedList<TreeNode>();
	
	TreeNode cur = root;
	// 同属判断栈不为空和当前树是否存在
	while (cur != null || sn.isEmpty()) {
		// 树非空
		if(cur ! = null) {
		// 一路寻找左子树，将路径保存在栈
			sn.push(cur);
			cur = cur.left
		} else {
			cur = sn.pop();
			li.add(cur.val);
			cur = cur.right;
		}
	}
	return li;
}
```

