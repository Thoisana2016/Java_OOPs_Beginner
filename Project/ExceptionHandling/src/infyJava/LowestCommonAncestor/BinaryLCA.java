package infyJava.LowestCommonAncestor;

class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class BinaryLCA {
    Node root;
    public static Node findLCA(Node node, int n1, int n2){
        if (node == null){
            return null;
        }

        if (node.val == n1 || node.val == n2){
            return node;
        }
        Node leftLCA = findLCA(node.left , n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null){
            return node;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        BinaryLCA tree =  new BinaryLCA();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(tree.root, 4, 5);
        System.out.println("LCA of 4 and 5 is: " + lca.val);

        lca = tree.findLCA(tree.root, 4, 6);
        System.out.println("LCA of 4 and 6 is: " + lca.val);

        lca = tree.findLCA(tree.root, 3, 4);
        System.out.println("LCA of 3 and 4 is: " + lca.val);

        lca = tree.findLCA(tree.root, 2, 4);
        System.out.println("LCA of 2 and 4 is: " + lca.val);
    }
}
