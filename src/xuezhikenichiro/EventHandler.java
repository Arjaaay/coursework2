package xuezhikenichiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class EventHandler implements ActionListener, Terminable {
	private final Communication communication;
	private final ASCIITranslator translator;
	private Thread currentThread;

	
	EventHandler(Communication communication) throws IOException{
		this.communication = communication;
		this.translator = new ASCIITranslator(new File("ascii_table.csv"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentThread != null)currentThread.interrupt();
		
		List<Integer> positions = new ArrayList<>();
		JTextArea textArea = communication.textArea();
		String inputText = textArea.getText();
		for(int i = 0, n = inputText.length(); i < n; i++){
			char letter = inputText.charAt(i);
			positions.addAll(translator.toIntPair(letter));
		}
		
		currentThread = new Sender(positions, this);
		currentThread.start();
		communication.setTitle("Sending...");
		
		textArea.setText("");
	}
	@Override
	public void onTerminate() {
		communication.setTitle(communication.initialTitle());
	}
	public void manipulateCamera(List<Integer> positions) throws InterruptedException{
		communication.camera().pointsTo(positions, 1000, this);
	}
}
