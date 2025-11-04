package infyJava.ValidateBinarySearchTree;

class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class ValidateBalanceBinaryTree {

    public static boolean isValidBBT(TreeNode root){
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(TreeNode node, long min, long max){
        //base case
        if (node == null){
            return true;
        }

        if (node.data <= min || node.data >= max){
            return  false;
        }

        return isValid(node.left, min, node.data) &&
                isValid(node.right, node.data, max);
    }

    public static void main(String[] args) {
        ValidateBalanceBinaryTree tree = new ValidateBalanceBinaryTree();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Validate Balance Binary Tree :");
        System.out.println(isValidBBT(root));
    }
}
