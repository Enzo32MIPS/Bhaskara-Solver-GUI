import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main{
	public static void main(String[] args){

		try {
    		UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
    		System.err.println("Failed to initialize FlatLaf");
		}

		//Color customColor = new Color(40,43,48);
		ImageIcon customIcon = new ImageIcon(Main.class.getResource("/quill-pen-fill.png"));
		JFrame frame = new JFrame("Calculadora Bhaskara");
		frame.setSize(440,240);
		frame.setLayout(null);
		frame.setIconImage(customIcon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setBackground(customColor);
		System.out.println("Window successfully created");

		JLabel labelA = new JLabel("X²+");
		labelA.setBounds(165,40,20,25);
		frame.add(labelA);
		JTextField fieldA = new JTextField();
		//labelA.setForeground(Color.WHITE);
		frame.add(fieldA);
		fieldA.setBounds(125,40,30,25);
		System.out.println("LabelA and FieldA loaded");

		JLabel labelB = new JLabel("X+");
		frame.add(labelB);
		labelB.setBounds(235,40,30,25);
		JTextField fieldB = new JTextField();
		//labelB.setForeground(Color.WHITE);
		frame.add(fieldB,BorderLayout.CENTER);
		fieldB.setBounds(195,40,30,25);
		System.out.println("LabelB and FieldB loaded");

		JTextField fieldC = new JTextField();
		frame.add(fieldC);
		fieldC.setBounds(260,40,30,25);
		System.out.println("FieldC loaded");

		JButton sbutton = new JButton("Solucionar");
		sbutton.setBounds(160, 90, 100, 30);
		//sbutton.setForeground(Color.WHITE);
		frame.add(sbutton,BorderLayout.CENTER);

		JLabel labelres = new JLabel("X1 = ?   X2 = ?");
		labelres.setBounds(175,130,110,25);
		//labelres.setForeground(Color.WHITE);
		frame.add(labelres);

		String[] items = {"Light mode", "Dark mode"};

		JComboBox<String> dropdown = new JComboBox<>(items);
		dropdown.setBounds(5,165,150,30);
		frame.add(dropdown);

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
				labelres.setBounds((185-length), 130, 200, 25);

			} else {
				labelres.setText("Preencha os campos");
				String temp5 = labelres.getText();
				int length2 = temp5.length();
				labelres.setBounds((175-length2),130,150,25);
			}
		});

		dropdown.addActionListener(e -> {
            String selected = (String) dropdown.getSelectedItem();
			if (selected == "Dark mode"){
				try{
					//frame.setVisible(false);
					UIManager.setLookAndFeel(new FlatDarkLaf());
					//frame.setVisible(true);
				} catch (Exception ex){
					System.err.println("Failed to change themes");
				}
			} else {
				try {
					//frame.setVisible(false);
					UIManager.setLookAndFeel(new FlatLightLaf());
					//frame.setVisible(true);
				} catch (Exception ex){
					System.err.println("Failed to change themes");
				}
			}

			SwingUtilities.updateComponentTreeUI(frame);

            //JOptionPane.showMessageDialog(frame, "You selected: " + selected);
        });
	}
}
