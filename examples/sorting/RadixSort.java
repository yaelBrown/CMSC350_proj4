// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a method that performs the radix sort on an array
// of elements.

package sorting;

class RadixSort
{
	private static final int BASE = 10, DIGITS = 4;

	public static void sort(Integer[] values)
	{
		int index, bin, length = values.length;
		int[][] bins = new int[BASE][length];
		int[] indexes = new int[BASE];
		for (int digit = 1; digit <= DIGITS; digit++)
		{
			for (int i = 0; i < BASE; i++)
				indexes[i] = 0;
			for (int i = 0; i < length; i++)
			{
				bin = getDigit(values[i], digit);
				bins[bin][indexes[bin]++] = values[i];
			}
		   index = 0;
			for (bin = 0; bin < BASE; bin++)
				for (int i = 0; i < indexes[bin]; i++)
					values[index++] = bins[bin][i];
		}
	}

	private static int getDigit(int number, int whichDigit)
	{
		while (whichDigit-- > 1)
			number /= BASE;
		return number % BASE;
	}
}