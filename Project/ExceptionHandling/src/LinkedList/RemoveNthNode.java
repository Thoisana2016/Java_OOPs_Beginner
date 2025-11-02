package LinkedList;

class NodeRm{
    int data;
    NodeRm next;
    NodeRm(int data){
        this.data = data;
        this.next = null;
    }
}


public class RemoveNthNode {

    public static NodeRm rmEle(NodeRm head, int n){
        int k = 0;
        NodeRm tmp = new NodeRm(-1);
        while (tmp != null){
            k++;
            tmp = tmp.next;
        }
        if (k-n == 0){
            return head.next;
        }
        tmp = head;
        for (int i = 1; i< k-n; i++){
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        return head;
    }
    public static void  printList(NodeRm head){
        while (head != null){
            System.out.print(head.data);
            if (head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        NodeRm head = new NodeRm(1);
        head.next = new NodeRm(4);
        head.next.next = new NodeRm(5);
        head.next.next.next = new NodeRm(2);
        head.next.next.next.next = new NodeRm(6);
        head.next.next.next.next.next = new NodeRm(3);
        System.out.println("Printing list before remove");
        printList(head);
        System.out.println();
        System.out.println("Remove Nth element from the end of the list");
        head = rmEle(head, 3);
        System.out.println("Printing list ");
        printList(head);
    }
}
