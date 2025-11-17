package Medium;

public class Question2487 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        printList(removeNodes(head));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nxt= curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        ListNode newHead = null;
        int max = Integer.MIN_VALUE;
        while (prev != null) {
            if (prev.val >= max) {
                ListNode next = prev.next;
                prev.next = newHead;
                newHead = prev;
                max = prev.val;
                prev = next;
            } else {
                prev = prev.next;
            }
        }

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
