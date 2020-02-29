//孩子表示法造一棵二叉树
class BTNode{
	BTNode left; //左节点
	BTNode right; //右节点
	int val;	//值
	
	public BTNode(int val) {
		this.val = val;
	}
}

//前序遍历，根、左、右 并将结点值域打印
public void preOrder(BTNode root) {
	if(root != root) {
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
}

//中序遍历，左、根、右 
public void inOrder(BTNode root) {
	if(root != null) {
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}
}

//后续遍历，左、右、根
public void postOrder(BTNode root) {
	if(root != null) {
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val);
	}
}

//求一棵二叉树叶子结点的个数
public int getLeafNode(BTNode root) {
	if(root == null) {
		return 0;
	}
	if(root.left == null && root.right == null) {
		return getLeafNode(root.left) + getLeafNode(root.right);
	}
}

//获取第K层结点的个数
public int countLevelNode(BTNode root,int k) {
	if(root == null || k < 1) {
		return 0;
	}
	if(k == 1) {
		return 1;
	}
	//求k-1层的结点树
	return countLevelNode(root.left,k-1) + countLevelNode(root.right,k-1);
}














