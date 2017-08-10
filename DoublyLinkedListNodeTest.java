/**
 * This class tests the DoublyLinkedList
 * @author Nada-Al-Thawr
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListNodeTest {
	// creating all the testing lists
	DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
	DoublyLinkedList<String> emptyList = new DoublyLinkedList<String>();
	DoublyLinkedList<String> headTailList = new DoublyLinkedList<String>();

	@Before
	// add to the lists
	public void createTestLists() {
		// set the head as "S"
		testList.head = new DoublyLinkedListNode<String>("S");
		// insert more elements
		testList.insertAfter(testList.head, "E");
		testList.insertAfter(testList.head.getNext(), "A");
		// ensuring that the tail is being set as "A"
		testList.tail = new DoublyLinkedListNode<String>("A");

		// adding to the two element list
		headTailList.head = new DoublyLinkedListNode<String>("one");
		headTailList.tail = new DoublyLinkedListNode<String>("two");
		// creating the nodes
		DoublyLinkedListNode<String> headNode = (DoublyLinkedListNode<String>) headTailList.head;
		DoublyLinkedListNode<String> tailNode = (DoublyLinkedListNode<String>) headTailList.tail;

		// headTailList.head.setData("one");
		// headTailList.tail.setData("two");

		// setting previous and next
		headTailList.tail.setPrevious(headNode);
		headTailList.head.setNext(tailNode);
		// System.out.println(headTailList);

	}

	/**
	 * Testing setPrevious
	 */
	@Test
	public void testSetPrevious() {
		// creating the first and new nodes
		DoublyLinkedListNode<String> firstNode = testList.getFirstNode();
		DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<String>(
				"N");
		// setting previous
		testList.tail.setPrevious(newNode);
		testList.tail.getPrevious().setPrevious(firstNode);
		String message = "Testing set previous, calling it one time.";
		assertEquals(message, "N", testList.tail.getPrevious().toString());
		System.out.println(testList);

	}

	/**
	 * testing getPrevious
	 */
	@Test
	public void testGetPrevious() {
		// System.out.println("Testing getPrevious: "
		// + headTailList.tail.getPrevious());
		assertEquals("getPrevious", "one", headTailList.tail.getPrevious()
				.toString());

	}

	/**
	 * testing setNext
	 */
	@Test
	public void testSetNext() {

		DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<String>(
				"J");
		String message = "Testing set previous, calling it one time.";
		// setting next as the new node
		testList.head.setNext(newNode);
		assertEquals(message, "J", testList.head.getNext().toString());
		System.out.println("This is set next test: " + testList);
		System.out.println(testList.tail.toString());

	}

	/**
	 * testing getNext
	 */
	@Test
	public void testGetNext() {

		System.out.println("Testing getNext: " + headTailList.head.getNext());
		assertEquals("getNext", "two", headTailList.head.getNext().toString());
	}

}
