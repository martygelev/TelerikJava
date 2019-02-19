package dsa;
import java.util.*;

public class Swapping {
    static class ListNode {
        public int value;
        public ListNode leftNode;
        public ListNode rightNode;


        public  ListNode(ListNode end,int r){
            this.value=r;
            this.setLeftNode(end);
            this.setRightNode(null);

            if(end != null)
            {
                end.setRightNode(this);
            }
        }

        public static void Detach(ListNode x){
            if(x.getLeftNode() != null)
            {
                x.getLeftNode().setRightNode(null);
            }
            if(x.getRightNode() != null)
            {
                x.getRightNode().setLeftNode(null);
            }

            x.setLeftNode(null);
            x.setRightNode(null);
        }

        public static void Attach(ListNode l, ListNode r)
        {
            if(l == r)
            {
                return;
            }

            l.setRightNode(r);
            r.setLeftNode(l);
        }

        public int getValue() {
            return value;
        }

        public ListNode getLeftNode() {
            return leftNode;
        }

        public ListNode getRightNode() {
            return rightNode;
        }

        public void setLeftNode(ListNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(ListNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] swaps = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ListNode[] nodes = new ListNode[n + 1];
        for(int i = 1; i < n+1; ++i)
        {
            nodes[i] = new ListNode(nodes[i - 1], i);
        }
         ListNode first = nodes[1];
         ListNode last = nodes[n];

        for (int swap : swaps) {
            ListNode middle = nodes[swap];
            ListNode newRight = middle.getLeftNode();
            ListNode newLeft = middle.getRightNode();

            ListNode.Detach(middle);
            ListNode.Attach(last, middle);
            ListNode.Attach(middle, first);

            first = newLeft;   //?? middle;
            last = newRight;    //?? middle;
        }

        int[] numbers = new int[n];

        for(int i = 0; i < n; ++i)
        {
            numbers[i] = first.getValue();
            first = first.getRightNode();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
