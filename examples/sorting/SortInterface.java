// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines a functional interface that includes a method
// for sorting an array of ordered elements. It provides a default swap method
// also.

package sorting;

@FunctionalInterface
interface SortInterface<T extends Comparable<T>>
{
	void sort(T[] array);
	
	default void swap(T[] array, int i, int j)
	{
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}