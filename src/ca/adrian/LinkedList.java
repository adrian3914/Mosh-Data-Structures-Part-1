package ca.adrian;

import java.util.NoSuchElementException;

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
    private int size;

    public void addLast(int item){
        var node = new Node(item);

        if (isEmpty()){
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;

        while (current != null){
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last){
            first = last = null;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last){
            first = last = null;
        }else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        if (isEmpty())
            throw new NoSuchElementException();

        int[] array = new int[size];
        var next = first;
        var index = 0;

        while (next != null){
            array[index++] = next.value;
            next = next.next;
        }
        return array;
    }

    private Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public void reverse(){
        // [10 <- 20    30 -> 40 -> 50]
        //  p     c     n
        if (first == null)
            return;

        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }


    public int getKthFromTheEnd(int k){
        // 1 -> 2 -> 3 -> 4 -> 5
        //           *         *
        // distance = k -1 -> nodes between last node and kth
        if (isEmpty())
            throw new IllegalArgumentException();

        var a = first;
        var b = first;

        for (int i = 0; i < (k-1); i++){
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last){
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void printMiddle() {
        // 1 -> 2 -> 3 -> 4
        //      a
        //           b

        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public void print(){
        var next = first;

        while (next != null){
            System.out.println(next.value);
            next = next.next ;
        }
    }

    private boolean isEmpty(){
        return  first == null;
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
}
