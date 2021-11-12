package com.example.awtDemo;

// awt means abstract window toolkit

// brings everything from java.awt package
import java.awt.*;

// brings WindowAdapter class from java.awt.event package
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// creates a window
public class MyWindow extends Frame {

    public MyWindow(String title) {
        super(title);
        setSize(500, 140);

        // if you click 'Close' in the window, it overrides the standard function and actually closes down the app
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // method that actually draws the screen
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("by Tim Buchalka", 60, 100);
    }
}
