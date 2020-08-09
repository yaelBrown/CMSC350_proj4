// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a method that performs the bubble sort on an array
// of elements that implement the Comparable interface.

package sorting;

class BubbleSort<T extends Comparable<T>> implements SortInterface<T>
{
	@Override
	public void sort(T[] array)
	{
		for (int i = 0; i < array.length; i++)
			for (int j = array.length - 1; j > i; j--)
				if (array[j].compareTo(array[j - 1]) < 0)
					swap(array, j, j - 1);
	}
	
	@Override
	public String toString()
	{
		return "Bubble Sort";
	}
}