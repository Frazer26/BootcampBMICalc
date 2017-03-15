package org.sonatype.bmi;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BMIJFrame extends JFrame {

	static BMIJFrame frame;
	private JPanel contentPane;
	private JTextField textHeight1;
	private JTextField textWeight;
	private JTextField textAge;
	private JTextField txtpnResults;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BMIJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMIJFrame() {
		setResizable(false);		
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBmiTitle = new JLabel("BMI healthy weight calculator");
		lblBmiTitle.setBounds(5, 5, 432, 18);
		lblBmiTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBmiTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBmiTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBmiTitle.setForeground(SystemColor.textHighlight);
		contentPane.add(lblBmiTitle);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setBounds(5, 80, 58, 21);
		contentPane.add(lblHeight);
		
		textHeight1 = new JTextField();
		textHeight1.setBounds(61, 81, 86, 20);
		contentPane.add(textHeight1);
		textHeight1.setColumns(10);
		
		String[] heightValues = { "Centimeters","Meters", "Inches"};
		final JComboBox heightCombo = new JComboBox(heightValues);
		heightCombo.setBounds(157, 81, 106, 20);
		contentPane.add(heightCombo);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWeight.setBounds(5, 128, 58, 21);
		contentPane.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setColumns(10);
		textWeight.setBounds(61, 129, 86, 20);
		contentPane.add(textWeight);
		
		String[] weightValues = { "Kilograms", "Pounds"};
		final JComboBox weightCombo = new JComboBox(weightValues);
		weightCombo.setBounds(157, 129, 106, 20);
		contentPane.add(weightCombo);
		
		txtpnResults = new JTextField();
		txtpnResults.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnResults.setText("Results");
		txtpnResults.setBounds(157, 185, 144, 30);
		contentPane.add(txtpnResults);
		txtpnResults.setEditable(false);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAge.setBounds(5, 48, 58, 21);
		contentPane.add(lblAge);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(61, 49, 86, 20);
		contentPane.add(textAge);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				//Error handling
								
				if (textAge.getText().isEmpty() || textHeight1.getText().isEmpty() || textWeight.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(
	                        frame,
	                        "Every fields must be filled!",
	                        "ERROR",
	                        JOptionPane.ERROR_MESSAGE);
	                return;
	            }
				
				try{
					Integer.parseInt((textAge.getText()));
				}
				catch (Exception e) {
						JOptionPane.showMessageDialog(
		                        frame,
		                        "Age must be integer!",
		                        "ERROR",
		                        JOptionPane.ERROR_MESSAGE);
		                return;		           
				}
				
				try{
					Double.parseDouble(textHeight1.getText().replace(',', '.'));
				}
				catch (Exception e) {
						JOptionPane.showMessageDialog(
		                        frame,
		                        "Height must be a number!",
		                        "ERROR",
		                        JOptionPane.ERROR_MESSAGE);
		                return;		           
				}
				if ( Double.parseDouble(textHeight1.getText().replace(',', '.'))<=0 || Double.parseDouble(textWeight.getText().replace(',', '.'))<=0 ) {
					JOptionPane.showMessageDialog(
	                        frame,
	                        "Please give greater number than 0!",
	                        "ERROR",
	                        JOptionPane.ERROR_MESSAGE);
	                return;
	            }
				
				if ( Integer.parseInt((textAge.getText()))<2 ) {
					JOptionPane.showMessageDialog(
	                        frame,
	                        "Please give greater number than 1!",
	                        "ERROR",
	                        JOptionPane.ERROR_MESSAGE);
	                return;
	            }
				
				try{
					Double.parseDouble(textWeight.getText().replace(',', '.'));
				}
				catch (Exception e) {
						JOptionPane.showMessageDialog(
		                        frame,
		                        "Weight must be a number!",
		                        "ERROR",
		                        JOptionPane.ERROR_MESSAGE);
		                return;		           
				}
				
				//implementation (megvalósítás)
				
				BmiCalculator bmiCalc = new BmiCalculator(Integer.parseInt (textAge.getText()), Double.parseDouble(textHeight1.getText().replace(',', '.')), Double.parseDouble(textWeight.getText().replace(',', '.')) );  //paraméteres konstruktorral létrehozás (bmiCalculator példányát feltöltöm értékekkel)
				
				if ("Meters".equals(heightCombo.getSelectedItem())){
					bmiCalc.meterToCentimeter();
				}
				else if("Inches".equals(heightCombo.getSelectedItem())){
					bmiCalc.inchToCentimeter();
				}
				
				if ("Pounds".equals(weightCombo.getSelectedItem())){
					bmiCalc.poundsToKilogram();
				}
				txtpnResults.setText(bmiCalc.result());
				
		}
		});
		btnCalculate.setBounds(61, 189, 91, 23);
		contentPane.add(btnCalculate);
	}
}
