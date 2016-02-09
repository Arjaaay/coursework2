package xuezhikenichiro;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("");
		myFrame.setSize(300,80);
		
		JSlider mySlider = new JSlider();
		
		
		myFrame.setLayout(new BorderLayout());
		JPanel jTop = new JPanel();
		myFrame.add(jTop, BorderLayout.CENTER);
		jTop.add(mySlider);

		
// test 
		
		
		
		myFrame.setVisible(true);
	}
	
}
