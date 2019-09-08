package org.instagram;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File Chooser
 */
public class FileChooser implements ActionListener {
	JLabel l;

	// a default constructor
	FileChooser(JLabel l) {
		this.l = l;
	}

	public void actionPerformed(ActionEvent evt) {
		// if the user presses the save button show the save dialog
		String com = evt.getActionCommand();
		System.out.println(com);
		// create an object of JFileChooser class
		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView()
				.getHomeDirectory());

		// set the selection mode to directories only
		j.setFileSelectionMode(JFileChooser.FILES_ONLY);

		// invoke the showsOpenDialog function to show the save dialog
		int r = j.showOpenDialog(null);

		if (r == JFileChooser.APPROVE_OPTION) {
			// set the label to the path of the selected directory
			l.setText(j.getSelectedFile().getAbsolutePath());
		} else {
			l.setText("the user cancelled the operation");
		}

	}
}
