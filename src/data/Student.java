package data;

public class Student {
	private String prename;
	private String surname;
	private int mn;
	private CourseList course;
	
	public Student(String prename, String surname, int mn, CourseList course) {
		super();
		this.prename = prename;
		this.surname = surname;
		this.mn = mn;
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student [ prename = " + prename + ", surname = " + surname + ", matriculation number = " + mn + ", course = " + course + " ]";
	}

	public String getPrename() {
		return prename;
	}

	void setPrename(String prename) {
		this.prename = prename;
	}

	public String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	public int getMn() {
		return mn;
	}

	void setMn(int mn) {
		this.mn = mn;
	}

	public CourseList getCourse() {
		return course;
	}

	void setCourse(CourseList course) {
		this.course = course;
	}
}

