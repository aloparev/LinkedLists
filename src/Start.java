import list.*;
import data.*;
import sort.*;


/**
 * @author Andrej Loparev 557966
 * Main with all menus needed
 *
 */
public class Start {
	static Listable<Student> sList = new SinglyLinkedList<Student>();
	static Listable<Student> dList = new DoublyLinkedList<Student>();

	public static void main(String[] args) {
		System.out.println("\nWelcome to self-made list-program!\n");
				
		int select;        
        do {
	        System.out.printf("\n\tMain Menu\n\n"	        		
	                + "1 singly linked list\n"
	                + "2 double linked list\n"
	                + "0 EXIT\n"
	                + "______________________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 2);        
	        switch(select) {
	        
	            case 0:
	                break;
	            
	            case 1:
	            	sMenu();
	                break;
	                
	            case 2:
	            	dMenu();
	                break;
	        }
        } while (select != 0);        
        System.out.println("\nProgram will be closed.\nSo long!\n");
	}  
	
	static void dMenu() {
		int select;        
        do {
	        System.out.printf("\n\n\tdoubly linked list menu\n"	 
	        		+ "1 compose a new element\n"
	                + "2 show the list-size\n"
	                + "3 print an element with index [i]\n"
	                + "4 print all list-elements\n"
	                + "5 delete an element with index [i]\n"
	                + "6 delete all list-elements\n"
	                + "0 MAIN MENU\n"
	                + "__________________________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 9);        
	        switch(select) {
	        
	            case 0:                    
	                break;
	            
	            case 1:
	            	System.out.printf("\n1 add to the head\n"
	            			+ "2 add to the tail\n");
	            	select = Tools.intCheck(1, 2);
	            	if (select == 1) dList.addToHead(Tools.composeStudent());
	            	else dList.addToTail(Tools.composeStudent());	            	
	                break;
	                
	            case 2:
	            	System.out.println("\nList-size: " + dList.size());
	                break;
	                
	            case 3:
	            	System.out.print("\nElement-index: ");
	            	Student s = dList.get(Tools.intCheck(0, 0));	            	
	            	System.out.println("\n" + s);
	                break;
	                
	            case 4:
	            	System.out.println();
	            	dList.printAll();
	                break;
	                
	            case 5:
	            	System.out.print("\nElement-index: ");
	            	dList.del(Tools.intCheck(0, 0));
	                break;
	                
	            case 6:
	            	dList.delAll();
	                break;
	        }
        } while (select != 0);
	}

	static void sMenu(){		
		int select;        
        do {
	        System.out.printf("\n\n\tsingly linked list menu\n"	 
	        		+ "1 compose a new element\n"
	                + "2 show the list-size\n"
	                + "3 print an element with index [i]\n"
	                + "4 print all list-elements\n"
	                + "5 delete an element with index [i]\n"
	                + "6 delete all list-elements\n"
	                + "7 search\n"
	                + "8 selection sort\n"
	                + "9 bubble sort\n"
	                + "0 MAIN MENU\n"
	                + "__________________________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 9);        
	        switch(select) {
	        
	            case 0:                    
	                break;
	            /*    
	            case 1:	            	
	            	System.out.printf("\n1 add to the head\n"
	            			+ "2 add to the tail\n");
	            	select = Tools.intCheck(1, 2);
	            	if (select == 1) sList.addToHead(Tools.composeStudent());
	            	else sList.addToTail(Tools.composeStudent());	            	
	                break;
	              */
	            case 1:
	            	Student student1 = new Student("Arbold", "Schwarz", 1, CourseList.law);
	        		Student student2 = new Student("Arcold", "White", 2, CourseList.music);
	        		Student student3 = new Student("Chris", "Deen", 3, CourseList.science);
	        		Student student4 = new Student("Daniel", "Black", 4, CourseList.maths);
	        		Student student5 = new Student("Enrico", "Solano", 5, CourseList.law);
	        		Student student6 = new Student("Frank", "Ronson", 6, CourseList.law);
	        		
	        		sList.addToHead(student6);
	            	sList.addToHead(student4);
	            	sList.addToHead(student2);
	            	sList.addToTail(student1);
	            	sList.addToTail(student5);
	            	sList.addToTail(student3);
	            	break;
	                
	            case 2:
	            	System.out.println("\nList-size: " + sList.size());
	                break;
	                
	            case 3:
	            	System.out.print("\nElement-index: ");
	            	Student s = sList.get(Tools.intCheck(0, 0));	            	
	            	System.out.println("\n" + s);
	                break;
	                
	            case 4:
	            	System.out.println();
	            	sList.printAll();
	                break;
	                
	            case 5:
	            	System.out.print("\nElement-index: ");
	            	sList.del(Tools.intCheck(0, 0));
	                break;
	                
	            case 6:
	            	sList.delAll();
	                break;
	                
	            case 7:
	            	searchMenu();
	                break;
	                
	            case 8:
	            	sortMenu(8);
	                break;
	                
	            case 9:
	            	sortMenu(9);
	                break;
	                
	        }
        } while (select != 0);
	}	
	
	/**
	 * @param s selects the sorting algorithm
	 * 8 = selection sort
	 * 9 = bubble sort
	 */
	static void sortMenu(int s) {
		int select;
		Sortable<Student> doSort;
		
		if(s == 8) doSort = new SelectionSort<Student>();
		else doSort = new BubbleSort<Student>();
		
        do {
	        System.out.printf("\n\tsort criterion\n"	        		
	                + "1 prename\n"
	                + "2 surname\n"
	                + "3 matriculation number\n"
	                + "4 course\n"
	                + "0 CANCEL\n"
	                + "______________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 4);        
	        switch(select) {
	        
	            case 0:                    
	                break;
	            
	            case 1:
	        		doSort.sort(sList, new PrenameComparator());
	        		sList.printAll();
	                break;
	                
	            case 2:
	            	doSort.sort(sList, new SurnameComparator());
	        		sList.printAll();
	                break;
	                
	            case 3:
	            	doSort.sort(sList, new MnComparator());
	        		sList.printAll();
	                break;
	                
	            case 4:
	            	doSort.sort(sList, new CourseComparator());
	        		sList.printAll();
	                break;	                
	        }
        } while (select != 0);
	}
	
	static void searchMenu() {
		int select;        
        do {
	        System.out.printf("\n\tsearch criterion\n"	        		
	                + "1 prename\n"
	                + "2 surname\n"
	                + "3 matriculation number\n"
	                + "4 course\n"
	                + "0 CANCEL\n"
	                + "______________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 4);        
	        switch(select) {
	        
	            case 0:                    
	                break;
	            
	            case 1:
	            	System.out.print("\nType prename: ");
	            	((SinglyLinkedList<Student>) sList).searchPrename(Tools.stringCheck());
	                break;
	                
	            case 2:
	            	System.out.print("\nType surname: ");
	            	((SinglyLinkedList<Student>) sList).searchSurname(Tools.stringCheck());
	                break;
	                
	            case 3:
	            	System.out.print("\nType matriculation number: ");
	            	((SinglyLinkedList<Student>) sList).searchMn(Tools.intCheck(0, 0));
	                break;
	                
	            case 4:
	            	System.out.print("\nChoose the course: ");
	            	CourseList c = CourseList.select();
	            	((SinglyLinkedList<Student>) sList).searchCourse(c);
	                break;	                
	        }
        } while (select != 0);
	}
}
