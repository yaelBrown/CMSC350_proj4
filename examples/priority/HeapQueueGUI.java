// CMSC 350 Data Structures and Analysis
// Week 7 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the GUI for the
// program that tests the HeapQueue class. The GUI allows the 
// user to input a list of integers, which are then sorted by a 
// succession of enqueue operations followed by dequeue operations.

package priority;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import queue.*;

class HeapQueueGUI extends JFrame implements ActionListener
{
	private final HeapQueue<Integer> queue = new HeapQueue(200);
	private final JTextField input = new JTextField(30),
		output = new JTextField(30);
	private final JButton sort = 
		new JButton("Descending Sort by Enqueuing then Dequeuing");

	public HeapQueueGUI()
	{
		super("Integer Sort Using Heap Priority Queue");
		setSize(500, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(), topRow = new JPanel(),
			middleRow = new JPanel(), bottomRow = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 10, 10));
		topRow.setLayout(new FlowLayout());
		topRow.add(new JLabel("Input Integer List: "));
		topRow.add(input);
		middleRow.add(sort);
		bottomRow.add(new JLabel("Sorted Output List: "));
		bottomRow.add(output);
		panel.add(topRow);
		panel.add(middleRow);
		panel.add(bottomRow);
		output.setEditable(false);
		add(panel);
		setLayout(new FlowLayout());
		sort.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		String inputList = input.getText(), outputList = "";
		String[] numberStrings = inputList.split(" ");
		ArrayList<Integer> numbers = new ArrayList();
		try
		{	
			for (String numberString: numberStrings)
				numbers.add(Integer.parseInt(numberString));
			for (Integer number: numbers)
				queue.enqueue(number);
			while (!queue.isEmpty())
				outputList += queue.dequeue() + " ";
			output.setText(outputList);
		}
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null, "Nonnumeric Input");
		}
		catch (QueueFull exception)
		{
			JOptionPane.showMessageDialog(null, "Queue Full");
		}
		catch (QueueEmpty exception)
		{
			JOptionPane.showMessageDialog(null, "Queue Empty");
		}
    }
	public static void main(String[] args) throws FileNotFoundException
	{
	
		HeapQueueGUI window = new HeapQueueGUI();
		window.setVisible(true);
	}
}
