package list;

import data.*;

/**
 * @author Andrej Loparev 557966
 *
 * @param <T>
 */
public class SinglyLinkedList<T> implements Listable<T> {
	
	private class Node {
		T data;
		Node next;
		
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
				tail = tail.next = nd;			
			}
		}
	}
/*
	@Override
	public void print(int index) {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}
		if (index < 0 || index > (counter - 1)) {
			System.out.println("Element [" + index + "] does not exist!");
			return;
		} 
		
		Node tmp = head;
		int i = 0;
		while (i != index) {
			tmp = tmp.next;
			i++;
		}
		Student s = (Student) tmp.data;
		System.out.println(s);		
	}
*/
	@Override
	public T get(int index) {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return null;
		}
		if (index < 0 || index > (counter - 1)) {
			System.out.println("Element with index [" + index + "] does not exist!");
			return null;
		} 
		
		Node tmp = head;
		int i = 0;
		while (i != index) {
			tmp = tmp.next;
			i++;
		}
		return tmp.data;
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
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}		
		if (index < 0 || index > (counter - 1)) {
			System.out.println("\nElement with index [" + index + "] does not exist!");
			return;
		}
		
		if(index == 0){
			head = head.next;
			System.out.println("\nElement with index [" + index + "] has been deleted successfully!");
			counter--;
			return;
		}
		
		Node temp = this.traverse(index - 1);
		if(temp.next != null) temp.next = temp.next.next;
		else temp = null;
		System.out.println("\nElement with index [" + index + "] has been deleted successfully!");
		counter--;
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
	
	public void searchPrename(String match) {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}
		boolean k = true;
		Node temp = head;
		while (temp != null) {
			Student s = (Student) temp.data;
			if (s.getPrename().equals(match)) {
				System.out.println(s);
				k = false;
			}
			temp = temp.next;
		}
		if(k) System.out.printf("\nNo results with \"%s\"!\n", match);
	}
	
	public void searchSurname(String match) {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}
		boolean k = true;
		Node temp = head;
		while (temp != null) {
			Student s = (Student) temp.data;
			if (s.getSurname().equals(match)) {
				System.out.println(s);
				k = false;
			}
			temp = temp.next;
		}
		if(k) System.out.printf("\nNo results with \"%s\"!\n", match);
	}
	
	public void searchMn(int match) {
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}
		boolean k = true;
		Node temp = head;
		while (temp != null) {
			Student s = (Student) temp.data;
			if (s.getMn() == match) {
				System.out.println(s);
				k = false;
			}
			temp = temp.next;
		}
		if(k) System.out.printf("\nNo results with \"%d\"!\n", match);
	}
	
	public void searchCourse(CourseList match){
		if (counter == 0) {
			System.out.println("\nThe list is empty!");
			return;
		}
		boolean k = true;
		Node temp = head;
		while (temp != null) {
			Student s = (Student) temp.data;
			if (s.getCourse() == match) {
				System.out.println(s);
				k = false;
			}
			temp = temp.next;
		}
		if(k) System.out.print("\nNo results with \"" + match + "\"!\n");
	}

	@Override
	public void set(int index, T data) {
		this.traverse(index).data = data;
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

		Node temp = head;
		if (temp != null) {
			for (int i = 0 ; i < index; i++) {
				if (temp.next == null) {
					return null;
				}
				temp = temp.next;
			}
			return temp;
		}
		return null;
	}
}
