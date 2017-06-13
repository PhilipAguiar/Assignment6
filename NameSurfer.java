/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		nameLabel = new JLabel("Name: ");
		add(nameLabel,SOUTH);
		
		nameField = new JTextField(30);
	    add(nameField,SOUTH);
	   nameField.addActionListener(this); 
	   
	    graphButton = new JButton("Graph");
	    clearButton= new JButton("Clear");
	    add(graphButton,SOUTH);
	    add(clearButton,SOUTH);
	    
	    graph = new NameSurferGraph();
	    add(graph);
	    
		
	    addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameField) {
			NameSurferEntry entry = nameData.findEntry(nameField.getText());
			graph.addEntry(entry);
			graph.update();
		}
		if (e.getSource() == graphButton) {
			NameSurferEntry entry = nameData.findEntry(nameField.getText());
			graph.addEntry(entry);
			graph.update();	
		}
		if (e.getSource() == clearButton) {
			graph.clear();	}
		
	}
	
	
/*instance variables*/

private  JLabel nameLabel;
private JTextField nameField;	
private NameSurferDataBase nameData = new NameSurferDataBase("names-data.txt");
private NameSurferGraph graph;
private JButton graphButton;
private JButton clearButton;

}


