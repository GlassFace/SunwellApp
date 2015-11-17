package app.sunwell;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;

public class Gui {
	
	private JFrame frame;
	private JPanel panel;
	private JTextArea textArea;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextArea textArea4;
	private JTextArea textArea5;
	private JTextArea textArea6;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private GridBagConstraints gridBagConstraints;
	private String imageSource1;
	private String imageSource2;
	private String imageSource3;
	private String appTitle;
	private String font;
	@Autowired
	ReadDataFromWebsite dataFromWebsite;
	
	public void setImageSource1(String imageSource1) {
		this.imageSource1 = imageSource1;
	}
	
	public void setImageSource2(String imageSource2) {
		this.imageSource2 = imageSource2;
	}
	
	public void setImageSource3(String imageSource3) {
		this.imageSource3 = imageSource3;
	}
	
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	
	public void setFont(String font) {
		this.font = font;
	}
	
	public void properties(JTextArea text) {
		text.setEditable(false);
		text.setBackground(null);
		text.setForeground(Color.lightGray);
		text.setFont(new Font(font, Font.BOLD, 12));
	}
	
	public void window() throws IOException {
		
		panel = new JPanel();
		frame = new JFrame(appTitle);
		panel.setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();
		textArea = new JTextArea();
		textArea2 = new JTextArea();
		textArea3 = new JTextArea();
		textArea4 = new JTextArea();
		textArea5 = new JTextArea();
		textArea6 = new JTextArea();
		label1 = new JLabel(new ImageIcon(imageSource1));
		label2 = new JLabel(new ImageIcon(imageSource2)); 
		label3 = new JLabel(new ImageIcon(imageSource3));
		
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		panel.add(label1, gridBagConstraints);
		
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		panel.add(label2, gridBagConstraints);
		
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		panel.add(label3, gridBagConstraints);
		
	while(true) {
		
		properties(textArea);
		textArea.setText(dataFromWebsite.read().get(0).toUpperCase());
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		panel.add(textArea, gridBagConstraints);
		
		properties(textArea2);
		textArea2.setText(dataFromWebsite.read().get(1).toUpperCase());
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		panel.add(textArea2, gridBagConstraints);
		
		properties(textArea3);
		textArea3.setText(dataFromWebsite.read().get(2).toUpperCase());
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		panel.add(textArea3, gridBagConstraints);
		
		properties(textArea4);
		textArea4.setText(dataFromWebsite.read().get(3).toUpperCase());
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		panel.add(textArea4, gridBagConstraints);
		
		properties(textArea5);
		textArea5.setText(dataFromWebsite.read().get(4));
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		panel.add(textArea5, gridBagConstraints);
		
		properties(textArea6);
		textArea6.setText(dataFromWebsite.read().get(5));
		gridBagConstraints.fill = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		panel.add(textArea6, gridBagConstraints);

		panel.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		}
	}
}
