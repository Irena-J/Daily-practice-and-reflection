//造一棵二叉树
class BTNode{
	BTNode left; //左节点
	BTNode right; //右节点
	int val;	//值
	
	public BTNode(int val) {
		this.val = val;
	}
}
//二叉树的节点个数
public int getNodeCount(BTNode root) {
	//空树
	if(root == null) {
		return 0;
	}
	return 1 + getNodeCount(root.left) + getNodeCount(root.right);
}