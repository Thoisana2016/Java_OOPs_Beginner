package infyJava.levelOrderTravesalBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class LevelOrder {

    Node root;
    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll(); // retive and remove the front of queue
            System.out.println(current.data+" ");
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void levelOrderPrinting(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.data+" ");
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Node root;
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.root = new Node(1);
        levelOrder.root.left = new Node(2);
        levelOrder.root.right = new Node(3);
        levelOrder.root.left.left = new Node(4);
        levelOrder.root.left.right = new Node(5);

        levelOrderTraversal(levelOrder.root);
        System.out.println();
        System.out.println("Level by Level Printing");
        levelOrderPrinting(levelOrder.root);
    }

}
