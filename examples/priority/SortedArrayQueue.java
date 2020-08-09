// CMSC 350 Data Structures and Analysis
// Week 7 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a priority queue implemented with a sorted array. 
// It provides the enqueue and dequeue operations.

package priority;

import queue.*;

class SortedArrayQueue<T extends Comparable<T>> 
	implements PriorityQueueInterface<T>
{
	private T[] queue;
	private int back = 0;
	
	public SortedArrayQueue(int size)
	{
		queue = (T[]) new Comparable[size];
	}
	
	@Override
	public void enqueue(T element) throws QueueFull
	{
		if (back == queue.length)
			throw new QueueFull();
		int i = back - 1;
		while (i >= 0 && element.compareTo(queue[i]) < 0)
		{
			queue[i + 1] = queue[i];
			i--;
		}
		queue[i + 1] = element;
		back++;   
	}

	@Override
	public T dequeue() throws QueueEmpty
	{
		if (isEmpty())
			throw new QueueEmpty();
		return queue[--back];
	}

	@Override
	public boolean isEmpty() 
	{
		return back == 0;
	}
	
	@Override
	public String toString()
	{
		return "Priority queue implemented with a sorted array";
	}
}
