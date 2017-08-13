package list;

/**
 * @author Andrej Loparev 557966
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements Listable<T> {
	
	private class Node {
		T data;
		Node next;
		Node prev;
		
		Node(T data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;
	public static int counter = 0;
	
	private Node add(T data) {
		if (data == null) {
			return null;
		}
		counter++;
		return new Node(data);
	}

	@Override
	public void addToHead(T data) {
		Node nd = add(data);
		if (nd != null) {
			if (head == null) {
				head = tail = nd;
			}
			else {	
				nd.next = head;
				head = nd;
			}
		}
	}

	@Override
	public void addToTail(T data) {
		Node nd = add(data);
		if (nd != null) {
			nd.next = null;
			if (head  == null) {
				head = tail = nd;
			}
			else {
				nd.prev = tail;
				tail = tail.next = nd;			
			}
		}
	}

	@Override
	public T get(int index) {
		Node tmp = this.traverse(index);
		return tmp.data;
	}
	
	private Node traverse(int index) {
		
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return null;
		}		
		if (index < 0 || index > (counter - 1)) {
			System.out.println("\nElement with index [" + index + "] does not exist!");
			return null;
		}		
		
		if(index == 0 || (counter / index) > 1) {
			Node temp = head;
			if (temp != null) {
				for (int i = 0 ; i < index; i++) {
					if (temp.next == null) return null;
					temp = temp.next;
				}
				return temp;
			}
		}
		else {
			Node temp = tail;
			if (temp != null) {
				for (int i = counter - 1; i > index; i--) {
					if (temp.prev == null) return null;
					temp = temp.prev;
				}
				return temp;
			}
		}
		return null;
	}

	@Override
	public void printAll() {
		if (counter == 0) System.out.println("\nThe list is empty!");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	@Override
	public int size() {
		return counter;
	}
	
	@Override
	public void del(int index) {
		
		// replace head
		if (index == 0) {
			head = head.next;
			if(head != null) head.prev = null;
			System.out.println("\nElement with index [" + index + "] has been deleted successfully!");
			counter--;
			return;
		}

		// replace tail
		if (index == counter - 1) {
			tail = tail.prev;
			tail.next = null;
			System.out.println("\nElement with index [" + index + "] has been deleted successfully!");
			counter--;
			return;
		}
		
		// middle case
		Node predecessor = this.traverse(index - 1);
		Node successor = this.traverse(index + 1);
		predecessor.next = successor;
		successor.prev = predecessor;
		
		Node temp = this.traverse(index);
		temp = null;
		System.out.println("\nElement with index [" + index + "] has been deleted successfully!");
		counter--;
		return;
	}

	@Override
	public void delAll() {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}	
			
		head = tail = null;
		counter = 0;
		System.out.println("\nAll elements successfully deleted!");
		
	}

	@Override
	public void set(int i, T element) {
	}
}