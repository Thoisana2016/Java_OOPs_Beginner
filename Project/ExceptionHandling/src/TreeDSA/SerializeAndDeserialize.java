package TreeDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNodess{
    int data;
    TreeNodess left, right;
    TreeNodess(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class SerializeAndDeserialize {

    public static ArrayList<Integer> seriaize (TreeNodess root){
    ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNodess> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNodess curr = q.poll();
            if (curr == null){
                arr.add(-1);
                continue;
            }
            arr.add(curr.data);
            q.add(curr.left);
            q.add(curr.right);
        }
        return arr;
    }

    public static TreeNodess deserialize(ArrayList<Integer> arr){
        if(arr.get(0) == -1){
            return null;
        }

        TreeNodess root = new TreeNodess(arr.get(0));
        Queue<TreeNodess> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()){
            TreeNodess curr = q.poll();
            if (arr.get(i) != -1){
                TreeNodess left = new TreeNodess(arr.get(i));
                curr.left = left;
                q.add(left);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNodess root = new TreeNodess(1);
        root.left = new TreeNodess(20);
        root.right = new TreeNodess(30);
        root.left.left = new TreeNodess(40);
        root.left.right = new TreeNodess(50);

        ArrayList<Integer> arr = seriaize(root);
        System.out.println("Serialized tree: " + arr);

        TreeNodess res = deserialize(arr);
        System.out.print("Level order: ");
        printLevelOrder(res);
    }

    public static void printLevelOrder(TreeNodess root) {
        if (root == null) return;
        Queue<TreeNodess> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNodess node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        System.out.println();
    }


}
