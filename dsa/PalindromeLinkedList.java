package ok;
import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
       // ListNode n3 = new ListNode(2);
       // ListNode n4 = new ListNode(1);

        n1.next = n2;
       // n2.next = n3;
       // n3.next = n4;

        System.out.println(isPalindrome(n1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode firstElement = head;
        List<Integer> list = new ArrayList<>();
        list.add(firstElement.val);
        int counter = 0;

        while (firstElement != null) {
            firstElement = firstElement.next;

            if (firstElement == null) {
                counter++;
                break;
            }
            list.add(firstElement.val);
            counter++;
        }

        for (int i = 0; i < counter / 2; i++) {
                int firstValue = list.get(i);
                int secondValue = list.get(counter - 1 - i);
                if (firstValue != secondValue) {
                    return false;
                }
            }

        return true;
    }
}