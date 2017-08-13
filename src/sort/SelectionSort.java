package sort;

import list.*;

public class SelectionSort<T> implements Sortable<T>{

	@Override
	public void sort(Listable<T> list, Comparator<T> compare) {
		int min;
		for(int i = 0; i < list.size(); i++){
			min = i;
			for(int j = i + 1; j < list.size(); j++){
				if(compare.compare(list.get(j), list.get(min)) < 0) min = j;				
			}
			swap(list, i, min);
		}
		System.out.println("\n\tSelection-sort has been applied successfully!");
	}
	
	private void swap(Listable<T> list, int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}