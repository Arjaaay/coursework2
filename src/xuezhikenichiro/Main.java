package xuezhikenichiro;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("");
		myFrame.setSize(300,80);
		
		JSlider mySlider = new JSlider();
		JLabel y = new JLabel("Yes");
		JLabel n = new JLabel("No");
		
		
		myFrame.setLayout(new BorderLayout());
		JPanel jTop = new JPanel();
		myFrame.add(jTop, BorderLayout.CENTER);
		jTop.add(mySlider);
		
		JPanel jLeft = new JPanel();
		myFrame.add(jLeft, BorderLayout.WEST);
		jLeft.add(y);
		
		
		
		JPanel jRight = new JPanel();
		myFrame.add(jRight, BorderLayout.EAST);
		jRight.add(n);
		
		
		

		
		
		
		myFrame.setVisible(true);
	}
	
}
