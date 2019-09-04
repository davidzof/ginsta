package org.instagram;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ginsta
 *
 * Allows uploading of images or video to Instagr@m from the desktop on Linux, Windows or Mac
 * Can upload to multiple accounts at once
 *
 * Does not allow video or image editing/cropping
 *
 * Videos: less than 60 seconds
 * Images: pre-edited
 *
 * (c) David George, 4/9/2019
 */
public class Ginsta extends JFrame implements ActionListener {
    // Jlabel to show the files user selects
    static JLabel l;


    // a default constructor
    Ginsta() {
    }

    public static void main(String args[]) {
        // frame to contains GUI elements
        JFrame f = new JFrame("Instagram Desktop Video and Image Uploader");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog
        JButton button1 = new JButton("save");

        // button to open open dialog
        JButton button2 = new JButton("open");

        // make an object of the class filechooser
        FileChooser f1 = new FileChooser();

        // add action listener to the button to capture user
        // response on buttons
        button1.addActionListener(f1);
        button2.addActionListener(f1);

        // make a panel to add the buttons and labels
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button1);
        p.add(button2);

        // set the label to its initial value
        l = new JLabel("no file selected");

        // add panel to the frame
        p.add(l);
        f.add(p);

        f.show();
    }

    public void actionPerformed(ActionEvent evt) {
    }
}
