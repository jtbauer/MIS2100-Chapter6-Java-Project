package Bauer.Joshua.Chapter6.Java.Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(160, 101, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(160, 132, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numerator:");
		lblNewLabel.setBounds(76, 104, 74, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Denominator:");
		lblNewLabel_1.setBounds(76, 135, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Calculate");

		btnNewButton.setBounds(76, 195, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(175, 199, 71, 19);
		frame.getContentPane().add(lblNewLabel_2);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double numerator = Double.parseDouble(textField.getText());
				double denominator = Double.parseDouble(textField_1.getText());

				SimpleMath math = new SimpleMath();
				

				try {
					double result = math.divide(numerator, denominator);
					lblNewLabel_2.setText(Double.toString(result));
				} catch (ArithmeticException e) {
					lblNewLabel_2.setText("Cannot divide by 0");
				}
			}
		});
	}
}
