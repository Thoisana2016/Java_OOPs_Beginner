package infyJava.invertBinaryTree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        left = right = null;
        this.val = val;
    }
}
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        //base case for empty tree
        if (root == null){
            return null;
        }

        //Swapping left and right subtree
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertBinaryTree.invertTree(root);
    }
}
