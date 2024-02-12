import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Calculator class implementing ActionListener interface
public class Calculator implements ActionListener{

	// GUI components
	JFrame frame;
	JTextField textfield;
	JButton[] numButtons = new JButton[10];
	JButton[] functButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	// Font for buttons
	Font myFont = new Font("Times New Roman", Font.BOLD, 20);
	
	// Variables to store numbers, result, and operator
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	// Constructor to initialize the calculator
	public Calculator() {
		// Initialize the frame
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 600);
		frame.setLayout(null);
		
		// Initialize textfield
		textfield = new JTextField();
		textfield.setBounds(50, 20, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		// Initialize buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		// Populate functButtons array
		functButtons[0] = addButton;
		functButtons[1] = subButton;
		functButtons[2] = mulButton;
		functButtons[3] = divButton;
		functButtons[4] = decButton;
		functButtons[5] = equButton;
		functButtons[6] = delButton;
		functButtons[7] = clrButton;
		functButtons[8] = negButton;
		
		// Add action listeners and set properties for functButtons
		for (int i = 0; i < 9; i++) {
			functButtons[i].addActionListener(this);
			functButtons[i].setFont(myFont);
			functButtons[i].setFocusable(false);
		}
		
		// Add action listeners and set properties for numButtons
		for (int i = 0; i < 10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFont(myFont);
			numButtons[i].setFocusable(false);
		}
		
		// Set bounds for functional buttons
		negButton.setBounds(50, 430, 95, 50);
		delButton.setBounds(153, 430, 95, 50);
		clrButton.setBounds(255, 430, 95, 50);
		
		// Initialize panel for number buttons
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		// Add buttons to the panel
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addButton);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subButton);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulButton);
		panel.add(delButton);
		panel.add(decButton);
		panel.add(numButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		// Add components to the frame
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(panel);
		frame.add(textfield);
		
		// Make the frame visible
		frame.setVisible(true);
	}
	
	// Main method to instantiate the Calculator class
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Calculator calc = new Calculator();
	}

	// ActionListener interface method
	@Override
	public void actionPerformed(ActionEvent e) {
		// Handles number button function
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		// Handles decimal button function
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		// Handles arithmetic operator button function
		if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = e.getActionCommand().charAt(0);
			textfield.setText("");
		}
		
		// Handles Clear button function
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		// Handles Delete button function
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
		// Handles Negative button function
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		
		// Handles Equals button function
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			// Perform arithmetic operation based on the operator
			switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
			}		
			textfield.setText(String.valueOf(result));
			num1 = result;  // Store result for potential further operations
		}
	}
}
