package sait.sll.utility;

public class SLL implements LinkedListADT {

    private Node head;
    private Node tail;
    private int size;

    // Roselle

    public void append(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }//append

    public void prepend(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }//prepend

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index for remove is out of range");

        if(index == 0) { // removing first
            head = head.getNext();
            if(head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            int count = 0;

            while(count < index - 1) {
                count++;
                current = current.getNext();
            }

            if(index == size - 1) {
                current.setNext(null);
                tail = current;
            } else {
                current.setNext(current.getNext().getNext());
            }
        }

        size--;
    }//delete

    @Override
    public int size() {
        int count = 0;
        Node current = head;
        while(current != null) {
            count++;
            current = current.getNext();        
        }
        return count;
    }//size

    // Zara

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        Node current = head;
        int count = 0;

        while(count < index) {
            current = current.getNext();
            count++;
        }

        current.setData(data);
    }

    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        Node current = head;
        int count = 0;

        while(count < index) {
            current = current.getNext();
            count++;
        }

        return current.getData();
    }

    @Override
    public int indexOf(Object data) {
        Node current = head;
        int index = 0;

        while(current != null) {
            if(current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
