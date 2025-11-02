package infyJava.diameterOfBinaryTree;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinaryDiameter {

    Node root;
    public static class Diameter{
        int value;
    }
    static int height(Node node, Diameter diameter){
        if (node == null)
            return 0;
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);
        diameter.value = Math.max(leftHeight+rightHeight, diameter.value);
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static int getDiameter(Node node){
        Diameter diameter =  new Diameter();
        height(node, diameter);
        return diameter.value;
    }

    public static void main(String[] args) {
        BinaryDiameter tree = new BinaryDiameter();
//        input 1
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);

//        input 2
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.left.left = new Node(3);
//        tree.root.left.left.left = new Node(4);

//        Input 3
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.right = new Node(7);
        tree.root.left.right.right.left = new Node(8);


        System.out.println("Diameter Length :");
        System.out.println(getDiameter(tree.root));

    }
}
