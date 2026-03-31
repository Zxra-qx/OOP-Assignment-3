package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {
    private static final long serialVersionUID = 1L;

    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void append(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    @Override
    public void prepend(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }

        size++;
    }

    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            prepend(data);
            return;
        }

        if (index == size) {
            append(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 0;

        while (count < index - 1) {
            current = current.getNext();
            count++;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node current = head;
        int count = 0;

        while (count < index) {
            current = current.getNext();
            count++;
        }

        current.setData(data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index for delete is out of range");
        }

        if (index == 0) {
            head = head.getNext();

            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            int count = 0;

            while (count < index - 1) {
                current = current.getNext();
                count++;
            }

            if (index == size - 1) {
                current.setNext(null);
                tail = current;
            } else {
                current.setNext(current.getNext().getNext());
            }
        }

        size--;
    }

    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node current = head;
        int count = 0;

        while (count < index) {
            current = current.getNext();
            count++;
        }

        return current.getData();
    }

    @Override
    public int indexOf(Object data) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(data)) {
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
}
