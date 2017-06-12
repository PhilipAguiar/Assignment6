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

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		nameLabel = new JLabel("Name: ");
		add(nameLabel,SOUTH);
	    add(name,SOUTH);
	    
	    graph = new JButton("Graph");
	    clear= new JButton("Clear");
	    add(graph,SOUTH);
	    add(clear,SOUTH);
	    
		name.addActionListener(this);
	    addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == name) {
		println(name.getText());	
		println(nameData.findEntry(name.getText()));}
		if (e.getSource() == graph) {
			println("graph" + name.getText());	}
		if (e.getSource() == clear) {
			println("clear");	}
		
	}
	
	
/*instance variables*/

private  JLabel nameLabel;
private JTextField name = new JTextField(20);	
private NameSurferDataBase nameData = new NameSurferDataBase("names-data.txt");


private JButton graph;
private JButton clear;
}


