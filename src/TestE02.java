import static org.junit.Assert.*;
import org.junit.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import data.*;
import list.*;

/**
 * @author Andrej Loparev 557966
 * jUnit SLL-tests
 * Because DLL was created on basis of SLL
 *
 */
public class TestE02 {

	private static Student student1, student2, student3, student4, student5, student6;
    private static Listable<Student> list = new SinglyLinkedList<Student>();
    
	@BeforeClass
	public static void before() throws Exception {		
		student1 = new Student("Arnold", "Anderson", 1, CourseList.law);
		student2 = new Student("Billy", "Brisk", 2, CourseList.music);
		student3 = new Student("Chris", "Colper", 3, CourseList.science);
		student4 = new Student("Daniel", "Deen", 4, CourseList.maths);
		student5 = new Student("Enrico", "Enderle", 5, CourseList.law);
		student6 = new Student("Frank", "Filardo", 6, CourseList.law);
	}

    @Before
    public void setUp() throws Exception {
    	list.delAll();
        list.addToHead(student6);
        list.addToHead(student5);
        list.addToHead(student4);
        list.addToHead(student3);
        list.addToHead(student2);
        list.addToHead(student1);
    }    
    
    @Test
    public void addToHead(){
    	list.addToHead(student3);
    	assertEquals(student3, list.get(0));
    	assertEquals(student1, list.get(1));
    }
    
    @Test
    public void addToTail(){
    	list.addToTail(student3);
    	assertEquals(student3, list.get(6));
    	assertEquals(student6, list.get(5));
    }
    
    @Test
    public void size(){
        assertEquals(6, list.size());
    }
    
    @Test
    public void get() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Student s = list.get(0);
        System.out.println(s);
        assertEquals("Student [ prename = Arnold, surname = Anderson, matriculation number = 1, course = law ]\r\n", outContent.toString());
    }
     
    
    @Test
	public void printAll() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		String match = 
			"Student [ prename = Arnold, surname = Anderson, matriculation number = 1, course = law ]\r\n" +	
			"Student [ prename = Billy, surname = Brisk, matriculation number = 2, course = music ]\r\n" +	
			"Student [ prename = Chris, surname = Colper, matriculation number = 3, course = science ]\r\n" +	
			"Student [ prename = Daniel, surname = Deen, matriculation number = 4, course = maths ]\r\n" +
			"Student [ prename = Enrico, surname = Enderle, matriculation number = 5, course = law ]\r\n" +
    	    "Student [ prename = Frank, surname = Filardo, matriculation number = 6, course = law ]\r\n";
        list.printAll();
        assertEquals(match, output.toString());
    }
    
    @Test
    public void del(){
    	list.del(0);
    	assertEquals(student2, list.get(0));
    }
    
    @Test
    public void delAll(){
    	list.delAll();
    	assertEquals(0, list.size());
    }

}
