package TreeDSA;


import java.util.LinkedList;
import java.util.Queue;

class TreeNodes {
    int val;
    TreeNodes left, right ;
    TreeNodes(int val){
        this.val = val;
    }
}

class Pair{
    TreeNodes nodes;
    int num;
    Pair(TreeNodes _node, int _num){
        nodes = _node;
        num = _num;
    }
}

public class WidthOfBinaryTree {

    public static int widthofBinaryTree(TreeNodes root){
        int ans = 0;
        if (root == null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++){
                int cur_id = q.peek().num-mmin;
                TreeNodes nodes = q.peek().nodes;
                q.poll();
                if (i == 0) first = cur_id;
                if (i == size-1) last = cur_id;
                if (nodes.left != null){
                    q.offer(new Pair( nodes.left, cur_id*2+1));
                }
                if (nodes.right != null){
                    q.offer(new Pair(nodes.right, cur_id*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNodes root = new TreeNodes(1);
        root.left = new TreeNodes(3);
        root.left.left = new TreeNodes(5);
        root.left.left.left = new TreeNodes(7);
        root.right = new TreeNodes(2);
        root.right.right = new TreeNodes(4);
        root.right.right.right = new TreeNodes(6);

        int maxWidth = widthofBinaryTree(root);
        System.out.println("Max Width of Binary Tree : "+maxWidth);

    }
}
