package ca.adrian.linkedList;

public class LinkedList {

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item){
        var node = new Node(item);

        if (first == null){
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void print(){
        var next = first;

        while (next != null){
            System.out.println(next.value);
            next = next.next ;
        }
    }
}
