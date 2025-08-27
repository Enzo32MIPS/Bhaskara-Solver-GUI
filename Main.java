import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main{
	public static void main(String[] args){

		Color customColor = new Color(40,43,48);
		ImageIcon customIcon = new ImageIcon("quill-pen-fill.png");
		JFrame frame = new JFrame("Calculadora Bhaskara");
		frame.setSize(440,240);
		frame.setLayout(null);
		frame.setIconImage(customIcon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(customColor);
		System.out.println("Window successfully created");

		JLabel labelA = new JLabel("X²+");
		labelA.setBounds(130,40,20,25);
		frame.add(labelA);
		JTextField fieldA = new JTextField();
		labelA.setForeground(Color.WHITE);
		frame.add(fieldA);
		fieldA.setBounds(75,40,50,25);
		System.out.println("LabelA and FieldA loaded");

		JLabel labelB = new JLabel("X+");
		frame.add(labelB);
		labelB.setBounds(255,40,50,25);
		JTextField fieldB = new JTextField();
		labelB.setForeground(Color.WHITE);
		frame.add(fieldB);
		fieldB.setBounds(195,40,50,25);
		System.out.println("LabelB and FieldB loaded");

		JTextField fieldC = new JTextField();
		frame.add(fieldC);
		fieldC.setBounds(305,40,50,25);
		System.out.println("FieldC loaded");

		JButton sbutton = new JButton("Solucionar");
		sbutton.setBounds(170, 90, 100, 30);
		sbutton.setBackground(Color.DARK_GRAY);
		sbutton.setForeground(Color.WHITE);
		frame.add(sbutton);

		JLabel labelres = new JLabel("X1 = ?   X2 = ?");
		labelres.setBounds(185,130,110,25);
		labelres.setForeground(Color.WHITE);
		//labelres.setFont(new Font("Times",Font.BOLD,11));
		frame.add(labelres);

		frame.setVisible(true);

		sbutton.addActionListener(e -> {

			String temp1 = fieldA.getText(); 
			String temp2 = fieldB.getText();
			String temp3 = fieldC.getText();

			if(!temp1.isEmpty() && !temp2.isEmpty() && !temp3.isEmpty()){

				double aa, bb, cc, temp, x1, x2;

				aa = Double.parseDouble(fieldA.getText());
				bb = Double.parseDouble(fieldB.getText());
				cc = Double.parseDouble(fieldC.getText());

				temp = (bb*bb)-(4*aa*cc);
				temp = Math.sqrt(temp);

				x1 = (-bb+temp)/(2*aa);
				x2 = (-bb-temp)/(2*aa);

				labelres.setText("X1 = " + x1 + " X2 = " +x2);
				String tempo = labelres.getText();
				int length = tempo.length();
				labelres.setBounds((185-length), 130, 110, 25);

			} else {
				labelres.setText("Preencha os campos");
				String temp5 = labelres.getText();
				int length2 = temp5.length();
				labelres.setBounds((175-length2),130,150,25);
			}
		});
	}
}
