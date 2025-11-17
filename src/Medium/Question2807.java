package Medium;


public class Question2807 {
    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        printList(insertGreatestCommonDivisors(head));

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

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = new ListNode(findGreatestCommonDivisors(tmp.val, curr.val));
            curr.next.next = tmp;
            curr = curr.next.next;
        }
        return head;
    }


    private static int findGreatestCommonDivisors(int num1, int num2) {
        while (true) {
            if (num1 % num2 == 0 || num2 % num1 == 0) {
                return Math.min(num1, num2);
            } else if (num1 > num2) {
                num1 %= num2;
            } else {
                num2 %= num1;
            }
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
