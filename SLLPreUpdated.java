package sait.sll.utility;

public abstract class SLL implements LinkedListADT{
	private Node head;
	private Node tail;
	private int size;
	
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
	public void remove(int index) throws IndexOutOfBoundsException {
	    if(index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("Index for remove is out of range");

	    if(index == 0) { // removing first
	        head = head.getNext();
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
	}//remove
	public int size() {
		int count = 0;
		Node current = head;
		while(current != null) {
			count++;
			current = current.getNext();		
		}
		return  count;
	}//size
}

