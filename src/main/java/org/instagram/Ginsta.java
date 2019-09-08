package org.instagram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Ginsta
 *
 * Allows uploading of images or video to Instagr@m from the desktop on Linux,
 * Windows or Mac Can upload to multiple accounts at once
 *
 * Does not (yet) allow video or image editing/cropping
 *
 * Videos: less than 60 seconds Images: pre-edited - note images should ideally
 * be 1080x1350 (portrait). 1080x1080 or 1080x638
 *
 * (c) David George, 4/9/2019
 */
public class Ginsta extends JFrame implements ActionListener {
	public static void main(String args[]) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// frame to contains GUI elements
		JFrame f = new JFrame("Instagram Desktop Video and Image Uploader");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GinstaUI ui = new GinstaUI();
		f.add(ui);
		f.pack();
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
	}
}