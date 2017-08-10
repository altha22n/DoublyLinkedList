/**
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class DoublyLinkedList<T> extends LinkedList<T> {
	protected DoublyLinkedListNode<T> tail;

	/**
	 * Get the head node of the list.
	 **/
	public DoublyLinkedListNode<T> getFirstNode() {
		// if the head is not null
		if (head != null) {
			// return the data in the head
			return (DoublyLinkedListNode<T>) head;
		} else {
			return null;
		}

	}

	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst(T data) {
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);
		if (head != null) {
			newNode.setNext(head);
			((DoublyLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);
			head = newNode;

		} else {

			this.head = newNode;
			this.tail = newNode;
		}
	}
 
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data) {
		// create a new linked list node
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);
		// create a second node that is the next after the current node
		if (currentNode.getNext() != null) {
			DoublyLinkedListNode<T> secondNode = (DoublyLinkedListNode<T>) currentNode
					.getNext();
			// set the current node as the new and new and the second
			currentNode.setNext(newNode);
			newNode.setNext(secondNode);
			((DoublyLinkedListNode<T>) currentNode.getNext())
					.setPrevious(currentNode);

			((DoublyLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);
		} else
			return;
	}

	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast(T data) {
		DoublyLinkedListNode<T> lastNode = (DoublyLinkedListNode<T>) getLastNode();
		if (lastNode != null) {
			// create a new node
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(data);
			// and make the second node the last one and set as the new one

			lastNode.setNext(newNode);
			((DoublyLinkedListNode<T>) lastNode.getNext())
					.setPrevious(lastNode);
			tail = newNode;
		} else
			return;

	}

	/**
	 * Remove head node
	 **/
	public void deleteFirst() {

		if (head == null) {
			return;
		}
		if (getFirstNode().getNext() == null) {
			head = null;
			tail = null;
		} else {
			// create a temp node as the next value after head
			DoublyLinkedListNode<T> tempNode = (DoublyLinkedListNode<T>) head
					.getNext();

			// set the current head as null and the temp node as the new head

			head = tempNode;
			tempNode.setPrevious(null);

		}

	}

	/**
	 * Remove tail node
	 **/
	public void deleteLast() {

		// create a current node as the head
		DoublyLinkedListNode<T> currentNode = (DoublyLinkedListNode<T>) head;
		if (head == null) {
			return;
		}
		if (currentNode.getNext() == null) {
			head = null;
			tail = null;

		} else {

			currentNode = (DoublyLinkedListNode<T>) getLastNode();

			tail = currentNode.getPrevious();
			tail.setNext(null);

		}

	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 **/
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {

		if (currentNode.getNext() == null) {
			return;
		}
		if (currentNode.getNext().getNext() == null) {
			currentNode.setNext(null);
			tail = currentNode;

		}
		// if the next node isn't null
		else {
			// set the temp node as the next after the next after current node
			DoublyLinkedListNode<T> tempNode = (DoublyLinkedListNode<T>) currentNode
					.getNext().getNext();
			// next node as null
			currentNode.setNext(null);
			// current node as temp node
			currentNode.setNext(tempNode);
			((DoublyLinkedListNode<T>) currentNode.getNext())
					.setPrevious(currentNode);

		} 
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty() {
		// if the head is empty
		if (tail == null) {
			// return true
			return true;
		}
		// else return false
		return false;

	}

}
