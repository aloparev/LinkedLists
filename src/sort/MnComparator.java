package sort;
import data.*;

public class MnComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getMn() - o2.getMn();
	}
}
