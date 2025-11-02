package LinkedList;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class MiddleOfList {

    public static int getLength(ListNode node){
        ListNode tmp = node;
        int count = 0;
        while (tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public static ListNode getMiddle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.data);
            if (node.next != null){
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        System.out.println("Lenght of linked List");
        int len = getLength(head);
        System.out.println("Length : "+len);
        System.out.println("Get Middle of the linked list");
        ListNode res = getMiddle(head);
        System.out.println("The Middle is : "+res.data);
    }

}
