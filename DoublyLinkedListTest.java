/**
 * This is a testing class to test the DoublyLinkedList and DoublyLinkedListNode functionalities
 * @author Nada-Al-Thawr
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	// create a new testLists
	DoublyLinkedList<String> testList = new DoublyLinkedList<String>();
	DoublyLinkedList<String> emptyList = new DoublyLinkedList<String>();
	DoublyLinkedList<String> headTailList = new DoublyLinkedList<String>();

	@Before
	// add to the lists
	public void createTestLists() {
		// insert to main testList
		testList.insertFirst("S");
		testList.insertFirst("E");
		testList.insertFirst("O");
		testList.insertFirst("T");
		testList.insertFirst("A");
		testList.insertFirst("T");
		testList.insertFirst("O");
		testList.insertFirst("P");

		// insert in the two element list
		headTailList.insertFirst("two");
		headTailList.insertFirst("one");

	}

	/**
	 * testing insertFirst
	 */
	@Test
	public void testInsertFirst() {
		// test insert first in an emptyList and not an empty list
		emptyList.insertFirst("E");
		testList.insertFirst("O");
		String message = "Testing insert first";
		assertEquals(message, "E", emptyList.toString());
		emptyList.insertFirst("Y");
		assertEquals(message, "YE", emptyList.toString());
		assertEquals(message, "OPOTATOES", testList.toString());
	}

	/**
	 * testing getFirstNode
	 */
	@Test
	public void testGetFirstNode() {
		// test get first node
		// checking the emptyList case as well
		String nullMessage = "Testing get first node, expecting null";
		assertEquals(nullMessage, null, emptyList.getFirstNode());
		String message = "Testing get first node, expecting P";
		assertEquals(message, "P", testList.getFirstNode().toString());

	}

	/**
	 * testing insertFirst
	 */
	@Test
	public void testInsertAfter() {
		// test insert after
		// checking the emptyList case as well
		String message = "Testing insert after, calling it one time.";
		testList.insertAfter(testList.getFirstNode().getNext(), "Y");
		assertEquals(message, "POYTATOES", testList.toString());
		assertEquals("Testing empty", "", emptyList.toString());

	}

	/**
	 * testing insertLast
	 */
	@Test
	public void testInsertLast() {
		// test insert last
		// checking the emptyList
		// checking the two element list
		String message = "Testing insertLast, calling it one time.";
		testList.insertLast("T");
		headTailList.insertLast("three");
		assertEquals(message, "POTATOEST", testList.toString());
		assertEquals("Testing emptyList", "", emptyList.toString());
		assertEquals("Testing LastNode of emptyList", null,
				emptyList.getLastNode());
		assertEquals("Testing lastNode of the testList", "T", testList
				.getLastNode().toString());
		assertEquals("Testing headTailList", "three", headTailList
				.getLastNode().toString());

	}

	/**
	 * testing deleteFirst
	 */
	@Test
	public void testDeleteFirst() {
		// test delete first
		// testing the emptyList and the two element test
		// testing each if/else statement
		testList.deleteFirst();
		emptyList.deleteFirst();
		headTailList.deleteFirst();
		String message = "Testing delete first, calling it one time.";
		assertEquals(message, "OTATOES", testList.toString());
		assertEquals("Testing deleteFirst on emptyList", "",
				emptyList.toString());
		// testing the second if statement
		assertEquals("Testing two element list", "two", headTailList.toString());
	}

	/**
	 * testing DeleteNext
	 */
	@Test
	public void testDeleteNext() {
		// test delete next
		// testing the emptyList and the two element test
		// testing each if/else statement
		testList.deleteNext(testList.getFirstNode());
		headTailList.deleteNext(headTailList.getFirstNode());
		String message = "Testing delete next, calling it one time.";
		assertEquals(message, "PTATOES", testList.toString());

		assertEquals("Testing two element list", "one", headTailList.toString());
		// System.out.println("head tail list: "+ headTailList.toString());
	}

	/**
	 * testing deleteLast
	 */
	@Test
	public void testDeleteLast() {
		// test delete last
		// testing the two element list
		// checking each if/else statement
		testList.deleteLast();
		headTailList.deleteLast();
		String message = "Testing delete last, calling it one time.";
		assertEquals(message, "POTATOE", testList.toString());
		assertEquals("Testing deleteLast on the two element list", "one",
				headTailList.toString());
	}

	/**
	 * testing isEmpty
	 */
	@Test
	public void testIsEmpty() {
		// testing an empty and not empty lists
		assertEquals(true, emptyList.isEmpty());
		assertEquals(false, testList.isEmpty());
		emptyList.insertFirst("A");
		assertEquals(false, emptyList.isEmpty());
	}

	/**
	 * testing set and get Previous
	 */
	@Test
	public void testSetPrevious() {
		DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<String>(
				"B");
		testList.tail.setPrevious(newNode);
		// testList.tail.getPrevious().setPrevious(firstNode);
		String message = "Testing set previous, calling it one time.";
		assertEquals(message, "B", testList.tail.getPrevious().toString());

	}

}
