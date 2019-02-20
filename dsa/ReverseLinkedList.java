package ok;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        System.out.println(n1 + "N1 reference;");
        ListNode n2 = new ListNode(2);
        System.out.println(n1 + "N2 reference;");

        ListNode n3 = new ListNode(3);
        System.out.println(n1 + "N3 reference;");

        ListNode n4 = new ListNode(4);
        System.out.println(n1 + "N4 reference;");

        ListNode n5 = new ListNode(5);
        System.out.println(n1 + "N5 reference;");

        n1.next = n2;
        System.out.println(n1 + "n1 . next");
        n2.next = n3;
        System.out.println(n2 + "n2 . next");

        n3.next = n4;
        System.out.println(n3 + "n3 . next");

        n4.next = n5;
        System.out.println(n4 + "n4 . next");

        ListNode result = reverseList(n1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode prevNode = null;

        while (currentNode != null) {
            ListNode temporaryNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = temporaryNode;
        }
        return prevNode;
    }
}
