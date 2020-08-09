// CMSC 350 Data Structures and Analysis
// Week 7 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines a priority queue by extending QueueInterface but
// specifying that its components must implement the Comparable interface.

package priority;

import queue.*;

public interface PriorityQueueInterface<T extends Comparable<T>>
	extends QueueInterface<T>
{
}
