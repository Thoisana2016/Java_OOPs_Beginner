package TreeDSA;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}

public class LowestCommonAncestor {

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        //base case
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left= lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);

        TreeNode ans = lca(root,root.right.right,root.right.left.left);
        System.out.println("Result :"+ans.val);

    }
}
