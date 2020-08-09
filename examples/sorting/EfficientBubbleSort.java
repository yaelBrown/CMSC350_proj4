// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a method that performs an efficient version of the bubble
// sort on an array of elements that implement the Comparable interface.

package sorting;

class EfficientBubbleSort<T extends Comparable<T>> implements SortInterface<T>
{
	@Override
	public void sort(T[] array)
	{
		int i = 0;
		boolean sorted = false;
		while (i < array.length && !sorted)
		{
			sorted = true;
			for (int j = array.length - 1; j > i; j--)
				if (array[j].compareTo(array[j - 1]) < 0)
				{
					swap(array, j, j - 1);
					sorted = false;
				}
			i++;
		}
	}
	
	@Override
	public String toString()
	{
		return "Efficient Bubble Sort";
	}
}