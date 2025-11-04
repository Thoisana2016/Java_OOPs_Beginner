package infyJava.maximumDepthBT;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class DepthBinaryTree {

    public static int height(TreeNode node){
        // base case : tree is empty
        if (node == null){
            return 0;
        }
        // compute height of left and right subtree;
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return Math.max(lHeight, rHeight)+1;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(8);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(11);

        System.out.println("Maximum Depth/Height : "+height(root));
    }
}
