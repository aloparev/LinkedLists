package sort;
import list.*;

public interface Sortable<T> {
	
	void sort(Listable<T> list, Comparator<T> compare);

}
