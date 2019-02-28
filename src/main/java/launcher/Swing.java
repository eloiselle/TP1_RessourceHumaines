package launcher;

import javax.swing.*;

public class Swing {
    
    
    public static void main(String[] arguments) {
        
        JLabel label = new JLabel("Hello World");
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("Hello World");
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.add(label);
        
        f.setVisible(true);
    }
}