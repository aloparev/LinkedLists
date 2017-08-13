package sort;

import list.*;

public class BubbleSort<T> implements Sortable <T> {

	@Override
	public void sort(Listable<T> list, Comparator<T> compare) {

		for (int i = 1; i < list.size(); ++i) {
			for (int j = 0; j < list.size() - i; ++j) {
				if (compare.compare(list.get(j), list.get(j + 1)) > 0) swap(list, j, j + 1);
			}
		}
		System.out.println("\n\tBubble-sort has been applied successfully!");
	}
	
	private void swap(Listable<T> list, int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}