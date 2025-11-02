package infyJava;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class BasicBinaryTree {

    Node root;
    public BasicBinaryTree(int val){
        root = new Node(val);
    }
    public BasicBinaryTree(){
        root = null;
    }

    static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.prev);
        System.out.print(node.data+" ");
        inOrder(node.next);
    }
    static void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.prev);
        preOrder(node.next);
    }
    static void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.prev);
        postOrder(node.next);
        System.out.print(node.data+" ");
    }


    public static void main(String[] args) {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.root = new Node(1);
        tree.root.prev = new Node(2);
        tree.root.next = new Node(3);
        tree.root.prev.prev = new Node(4);
        tree.root.prev.next = new Node(5);

        System.out.println("InOrder : ");
        inOrder(tree.root);
        System.out.println("\nPreOrder : ");
        preOrder(tree.root);
        System.out.println("\nPostOrder : ");
        postOrder(tree.root);
    }


}
