package LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class MergeTwoSortedList {

    public static void printList(Node node){
        while (node != null){
            System.out.print(node.data);
            if (node.next != null){
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }

    public static int lengthofList(Node head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static Node mergeSorted(Node node1, Node node2){
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (node2 != null && node1 != null){
            if (node1.data <= node2.data){
                curr.next = node1;
                node1 = node1.next;
            }else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 != null){
            curr.next = node1;
        }else {
            curr.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        // the input list should be sorted first, after that this code works

        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(7);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(8);

        Node res = mergeSorted(node1, node2);
        System.out.println("the sorted linked list after merge is ");
        printList(res);
        System.out.println();
        System.out.print("Length of Linked List : ");
        System.out.println(lengthofList(res));

//        ReverseList rl = new ReverseList();
//        rl.reverseList(res);
//        System.out.println("List after reverse ");
//        printList(res);
    }
}
