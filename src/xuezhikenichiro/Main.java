package xuezhikenichiro;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {

		int i;

		JFrame myFrame = new JFrame("");
		myFrame.setSize(500,500);

		Camera myCamera = new Camera();

		
		
		myFrame.setLayout(new BorderLayout());
		myFrame.add(myCamera, BorderLayout.NORTH);
		
		
		
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
