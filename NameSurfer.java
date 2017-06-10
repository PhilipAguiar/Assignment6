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

	 public void init() {
		 nameField = new JTextField(10);
		 add(new JLabel("Name"), SOUTH);
		 add(nameField, SOUTH);
		 nameField.addActionListener(this);
		 }
		 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == nameField) {
		 println("Hello, " + nameField.getText());
		 }
		 }
		/* Private instance variables */
		 private JTextField nameField;
		}

