// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a method that performs the quick sort on an array
// of elements that implement the Comparable interface.

package sorting;

class QuickSort<T extends Comparable<T>> implements SortInterface<T>
{
	@Override
	public void sort(T[] array)
	{
		quickSort(array, 0, array.length - 1);
	}
	
	public void quickSort(T[] array, int left, int right)
	{
		if (left < right)
		{
			int pivot = findPivot(array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}

	private int findPivot(T[] array, int left, int right)
	{
		int first = left++;
		while (left <= right)
		{
			while (left <= right && array[first].compareTo(array[left]) > 0)
				left++;
			while (left <= right && array[first].compareTo(array[right]) < 0)
				right--;
			if (left < right)
				swap(array, left++, right--);
		}
		swap(array, first, right);
		return right;
	}
	
	@Override
	public String toString()
	{
		return "Quick Sort";
	}
}