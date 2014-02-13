package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;

public class Ui extends JFrame implements ActionListener{

	private JTextField text;
	private JTextArea output;
	private JButton goKnop,browseKnop;
	private JLabel youtube,info;
	private MainController controller;
	private JFileChooser fileChooser;
	private Container content;
	
	public Ui(MainController c){
		super();
		controller = c;
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		init();
        content = this.getContentPane();
      
		content.add(youtube);
		content.add(info);
		content.add(text);
		content.add(goKnop);
		content.add(browseKnop);
		content.add(output);
	}
	private String url;
	
	public void init(){
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		output = new JTextArea();
		text = new JTextField("");
		text.setPreferredSize( new Dimension( 400, 24 ) );
		goKnop = new JButton("Download!");
		browseKnop = new JButton("zet locatie");
		
		text.addActionListener(this);
		goKnop.addActionListener(this);
		browseKnop.addActionListener(this);
		ImageIcon image = new ImageIcon("images/youtube.png");
		youtube = new JLabel("");
		youtube.setIcon(image);
		
		info = new JLabel("voor liedjes te downloaden, geef hieronder de url in of typ gewoon de naam van de artiest");

	}
	



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == goKnop){

			try {
				controller.extract_audio(text.getText());
				update();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == browseKnop){
			 int returnVal = fileChooser.showOpenDialog(content);
			
			 
			 if (returnVal == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getSelectedFile() : " 
			         +  fileChooser.getSelectedFile());
			      }
			 
			
		}
	}


	public void update() {
		output.setText(controller.getOuput());
		repaint();
	}



}
