package ca.adrian.linkedList;

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

    private Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
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

    // Reverse
    public void reverse(){
        var current = last;

        while(current != null){
            if (current.equals(first)){
                current.next = null;
                first = last;
                last = current;
                break;
            }

          var previous = getPrevious(current);
          current.next = previous;
          current = previous;
        }
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
