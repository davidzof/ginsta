package org.instagram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * GinstaUI
 *
 * (c) David George, 4/9/2019
 */
public class GinstaUI extends JPanel implements ActionListener {
	// Jlabel to show the files user selects
	JLabel fileName;
	JTextField user;
	JTextField pass;
	JTextArea caption;

	// a default constructor
	GinstaUI() {
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		// set the label to its initial value
		fileName = new JLabel("no file selected");

		JLabel userName = new JLabel("Username: ");
		add(userName);

		user = new JTextField(20);
		add(user);

		JLabel passWord = new JLabel("Password: ");
		add(passWord);

		pass = new JTextField(20);
		add(pass);

		JLabel comments = new JLabel("Write a caption: ");
		caption = new JTextArea(5, 20);

		add(comments);
		add(caption);

		JButton upload = new JButton("Upload");
		JButton openFile = new JButton("Open File");

		// make an object of the class filechooser
		FileChooser fileChooser = new FileChooser(fileName);

		upload.addActionListener(this);
		openFile.addActionListener(fileChooser);

		add(openFile);
		add(fileName);
		add(upload);
		add(new JLabel(""));

		SpringUtilities.makeCompactGrid(this, 5, 2, // rows, cols
				5, 5, // initialX, initialY
				5, 5);// xPad, yPad
	}

	public void actionPerformed(ActionEvent evt) {
		// upload
		String file = fileName.getText();
		String password = pass.getText();
		String username = user.getText();
		String comment = caption.getText();
		if (!file.isEmpty() && !password.isEmpty() && !username.isEmpty()
				&& !comment.isEmpty()) {
			//if (file.endsWith(".mp4")) {
				Instaface instaface = new Instaface();
System.out.println(username + " : " + password);
				instaface.loginWithProxy(username, password, "http", 8080, "145.239.169.41");
				//String message = instaface.uploadVideo(file, comment);
				//fileName.setText(message);
			//}
		}
	}
}
