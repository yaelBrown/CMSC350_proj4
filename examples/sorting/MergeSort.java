// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a method that performs the merge sort on an array
// of elements that implement the Comparable interface.

package sorting;

class MergeSort <T extends Comparable<T>> implements SortInterface<T>
{
	@Override
	public void sort(T[] array)
	{
		mergeSort(array, 0, array.length - 1);
	}
	
	public void mergeSort(T[] array, int left, int right)
	{
		if (left < right)
		{
			int middle = (left + right) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			T[] merged = merge(array, left, middle, right);
			int j = 0;
			for (int i = left; i <= right; i++)
				array[i] = merged[j++];
		}
	}

	private T[] merge(T[] array, int left, int middle, int right)
	{
		T[] merged = (T[]) new Comparable[right - left + 1];
		int first = left, second = middle + 1, merge = 0;
		while (first <= middle && second <= right)
			if (array[first].compareTo(array[second]) < 0)
				merged[merge++] = array[first++];
			else
				merged[merge++] = array[second++];
		while (first <= middle)
			merged[merge++] = array[first++];
		while (second <= right)
			merged[merge++] = array[second++];
		return merged;
	}

	@Override
	public String toString()
	{
		return "Merge Sort";
	}
}