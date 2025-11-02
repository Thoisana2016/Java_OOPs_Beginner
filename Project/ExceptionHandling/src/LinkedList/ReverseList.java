package LinkedList;

class LinkNode{
    int val;
    LinkNode next;
    LinkNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReverseList {
    public static LinkNode reverseList(LinkNode head){
        LinkNode prev = null;
        LinkNode curr = head;
        LinkNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void  printList(LinkNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(23);
        head.next.next = new LinkNode(21);
        head.next.next.next = new LinkNode(3);
        head.next.next.next.next = new LinkNode(2);

        System.out.println("Linked list brfor reverse ");
        printList(head);
        System.out.println();
        head = reverseList(head);
        System.out.println("Linked List after reverse");
        printList(head);

    }
}
