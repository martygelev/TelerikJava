package linkedListImpl;

public class SinglyLinkedList {

    private Node head=null;
    private Node tail=null;
    private int size = 0;

    public SinglyLinkedList(){}

    public boolean isEmpty(){
        return getSize()==0;
    }

    public int getFirst(){
        if (!isEmpty()){
            return  head.getValue();
        }
        return -1;
    }

    public int getLast(){
        if (!isEmpty()){
            return  tail.getValue();
        }
        return -1;
    }
    public void addFirst(int value){
        head = new Node(value,head);
        if (isEmpty()){
            tail=head;
        }
        size++;
        System.out.println("Added head node -> " + head.getValue());
    }

    public void addLast(int value){
        Node newNode = new Node(value,null);

        if (isEmpty()){
            head=newNode;
        }
        else{
            tail.setNext(newNode);
        }
            tail=newNode;
            size++;
        System.out.println("Added tail node -> "+ tail.getValue());
    }
    public int getSize() {
        return size;
    }


    private static class Node{
        private int value;
        private Node next;

        public Node(int value,Node node ){
            this.next = node;
            this.value=value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
