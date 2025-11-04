package infyJava.pathSum;

class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        left = right = null;
        this.data = data;
    }
}

public class PathSum {

    public static boolean hasPathSum(TreeNode node, int targetSum){
        if (node == null){
            return false;
        }
        if (node.left == null && node.right == null && targetSum == node.data){
            return true;
        }

        int remainingSum = targetSum - node.data;

        return hasPathSum(node.left, remainingSum) ||
                hasPathSum(node.right, remainingSum);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum ps = new PathSum();
        int target = 22;
        System.out.println("Path Sum of Binary Tree : "+hasPathSum(root, target));
    }
}
