// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines the vertices of a graph and implements the Displayable
// interface that makes graph drawing possible.

package graph;

class Vertex implements Displayable
{
	private static final int INCREMENT = 100, MAX_X = 500;
	private static int nextX = INCREMENT, nextY = INCREMENT;
	private final String name;
	private final int x;
	private final int y;
	
	public Vertex(String name)
	{
		this.name = name;
		x = nextX;
		y = nextY;
		nextX += INCREMENT;
		if (nextX == MAX_X)
		{
			nextX = INCREMENT;
			nextY += INCREMENT;
		}
	}
	
	@Override
	public int getX() 
	{
		return x;
	}

	@Override
	public int getY()
	{
		return y;
	}

	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}