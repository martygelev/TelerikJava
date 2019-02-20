package ok;

import java.util.*;

public class RemoveDubl {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode currentNode = head;
        List<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode.val);

            currentNode = currentNode.next;
        }
        list.sort(Comparator.reverseOrder());
        ListNode node = null;

        for (Integer integer : list) {
            node = new ListNode(integer);
            node = node.next;

        }
        return node;
    }
}
