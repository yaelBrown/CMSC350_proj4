// CMSC 350 Data Structures and Analysis
// Week 7 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a priority queue implemented with an unsorted array. 
// It provides the enqueue and dequeue operations.

package priority;

import queue.*;

class UnsortedArrayQueue<T extends Comparable<T>> implements
	PriorityQueueInterface<T>
{
	private final T[] queue;
	private int back = 0;
	
	public UnsortedArrayQueue(int size)
	{
		queue = (T[]) new Comparable[size];
	}
	
	@Override
	public void enqueue(T element) throws QueueFull
	{
		if (back == queue.length)
			throw new QueueFull();
		queue[back++] = element;
	}

	@Override
	public T dequeue() throws QueueEmpty
	{
		T maxElement = queue[0];
		int maxIndex = 0;
		
		if (isEmpty())
			throw new QueueEmpty();
		for (int i = 1; i < back; i++)
		{
			if (queue[i].compareTo(maxElement) > 0)
			{
				maxElement = queue[i];
				maxIndex = i;
			}
		}
		queue[maxIndex] = queue[--back];
		return maxElement;
	}

	@Override
	public boolean isEmpty() 
	{
		return back == 0;
	}
}