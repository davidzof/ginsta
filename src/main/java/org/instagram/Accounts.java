package org.instagram;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Accounts extends JFrame implements ActionListener {
	JTextField userName;

	public Accounts() {
		setTitle("Accounts");
		Container contentPane = getContentPane();
		//contentPane.setLayout(new MigLayout());
		setBackground(Color.GRAY);

		int style1 = Font.CENTER_BASELINE;
		Font font = new Font("Arial", style1, 13);
		
		String[] columnNames = { "User Name", "Password", "Proxy",
				"Last Access", "Enabled" };

		Object[][] data = {
				{ "bill", "pass1234", "http://www.proxy.com", new Integer(5),
						new Boolean(false) }
		 };

		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
		
		Dimension d = new Dimension(550, 300);
		this.setPreferredSize(d);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		userName = new JTextField(20);
		userName.addActionListener(this);
		this.add(userName);
	}

	public void actionPerformed(ActionEvent evt) {
		String text = userName.getText();

		setVisible(true);
	}
}
