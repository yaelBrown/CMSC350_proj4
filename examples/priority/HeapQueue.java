// CMSC 350 Data Structures and Analysis
// Week 7 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a priority queue implemented with a heap. It provides
// the enqueue and dequeue operations.

package priority;

import queue.*;

class HeapQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>
{
	private T[] queue;
	private int length = 1;

	public HeapQueue(int size)
	{
		queue = (T[]) new Comparable[size + 1];
	}

	@Override
	public void enqueue(T element) throws QueueFull
	{
		if (length == queue.length)
			throw new QueueFull();
		int node = length++;
		while (node > 1 && queue[node / 2].compareTo(element) < 0)
		{
			queue[node] = queue[node / 2];
			node /= 2;
		}
		queue[node] = element;
	}

	@Override
	public T dequeue() throws QueueEmpty
	{
		int node = 1;
		if (isEmpty())
			throw new QueueEmpty();
		T value = queue[--length];
		T maxValue = queue[node];
		node *= 2;
		while (node <= length)
		{
			if (node < length && queue[node].compareTo(queue[node + 1]) < 0)
				node++;
			if (value.compareTo(queue[node]) >= 0)
				break;
			queue[node / 2] = queue[node];
			node *= 2;
		}
		queue[node / 2] = value;
		return maxValue;
	}

	@Override
	public boolean isEmpty()
	{
		return length == 1;
	}

	@Override
	public String toString()
	{
		return "Priority queue implemented with a heap";
	}
}
