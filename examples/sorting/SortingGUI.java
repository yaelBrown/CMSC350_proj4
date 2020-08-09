// CMSC 350 Data Structures and Analysis
// Week 8 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the GUI for the
// program that tests a variety of sorting algorithms. The various sorting
// algorithms include the bubble sort, the efficient bubble sort, the merge 
// sort, the quick sort and the radix sort..

package sorting;

import java.awt.*;
import java.io.*;
import javax.swing.*;

class SortingGUI extends JFrame 
{
	private final JTextField input = new JTextField(50),
		output = new JTextField(50);
	private final JButton bubble = new JButton("Bubble Sort"), 
		eBubble = new JButton("Efficient Bubble"),
		merge = new JButton("Merge Sort"),
		quick =	new JButton("Quick Sort"),
		radix = new JButton("Radix Sort");

	public SortingGUI()
	{
		super("Integer Sort Using Various Sorting Algorithms");
		setSize(750, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(), topRow = new JPanel(),
			middleRow = new JPanel(), bottomRow = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 10, 10));
		topRow.setLayout(new FlowLayout());
		topRow.add(new JLabel("Input Integer List: "));
		topRow.add(input);
		middleRow.setLayout(new GridLayout(1, 5, 20, 10));
		middleRow.add(bubble);
		middleRow.add(eBubble);
		middleRow.add(merge);
		middleRow.add(quick);
		middleRow.add(radix);
		bottomRow.add(new JLabel("Sorted Output List: "));
		bottomRow.add(output);
		panel.add(topRow);
		panel.add(middleRow);
		panel.add(bottomRow);
		output.setEditable(false);
		add(panel);
		setLayout(new FlowLayout());
		bubble.addActionListener(event -> doSort(new BubbleSort<Integer>()));
		eBubble.addActionListener
			(event -> doSort(new EfficientBubbleSort<Integer>()));
		merge.addActionListener(event -> doSort(new MergeSort<Integer>()));
		quick.addActionListener(event -> doSort(new QuickSort<Integer>()));
		radix.addActionListener(event -> radixSort());
	}

	private void doSort(SortInterface<Integer> sortMethod)
	{
		Integer[] numbers = getNumbers();
		sortMethod.sort(numbers);
		putNumbers(numbers);
    }
	
	private void radixSort()
	{
		Integer[] numbers = getNumbers();
		RadixSort.sort(numbers);
		putNumbers(numbers);
	}
	
	private Integer[] getNumbers()
	{
		String inputList = input.getText();
		String[] numberStrings = inputList.split(" ");
		Integer[] numbers = new Integer[numberStrings.length];
		int i = 0;
		for (String numberString: numberStrings)
			numbers[i++] = Integer.parseInt(numberString);
		return numbers;
	}
	
	private void putNumbers(Integer[] numbers)
	{
		String outputString = "";
		for (Integer number: numbers)
			outputString += number + " ";
		output.setText(outputString);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		SortingGUI window = new SortingGUI();
		window.setVisible(true);
	}
}
