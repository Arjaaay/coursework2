package xuezhikenichiro;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Communication is a child class of {@link javax.swing.JFrame}.
 * Inside the frame, there are 3 components that are prepared to simulate the crude way of communication Matthew Damon tried establishing using the function of an abundant rover on Mars in the film,
 * a slide bar to model the camera of the rover,
 * a text field to enter the text from NASA,
 * and the send button to start communication between Matthew and NASA
 * from the top to the bottom.
 */
public class Communication extends JFrame{
	private static final long serialVersionUID = 3508413767028699251L;
	
	private final String initialTitle;
	private final Camera camera;
	private final JTextArea textArea;
	private final JButton button;
	private final ASCIITranslator translator;
	private final EventHandler handler;
	
	/**
	 * Prepares all the components which are going to work on the frame, and reads "ascii_table.csv" followed by launching ASCIITranslator using the file.
	 * The most sensitive part of this constructor is that an action listener which initiates a thread to perform the communication process is added to the button.
	 * The previously created thread is interrupted if another event happens. Thus, The process of manipulating the slider terminates and the newly created thread gets ready for action if the slider has already started to move.
	 * @param title The title of the frame. 
	 */
	public Communication(String initialTitle) throws IOException{
		this.initialTitle = initialTitle;
		this.camera = new Camera(16);
		this.textArea = new JTextArea();
		this.translator = new ASCIITranslator(new File("ascii_table.csv"));
		this.handler = new EventHandler(this);
		this.button = new JButton("Send");
		button.setMaximumSize(new Dimension(Short.MAX_VALUE, button.getHeight()));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(handler);
		
		
		setTitle(initialTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(camera);
		mainPanel.add(textArea);
		mainPanel.add(button);
		
		add(mainPanel);
	}
	public String initialTitle() {
		return initialTitle;
	}

	public Camera camera() {
		return camera;
	}

	public JTextArea textArea() {
		return textArea;
	}

	public JButton button() {
		return button;
	}
	public ASCIITranslator translator() {
		return translator;
	}
	
	
	
	
	public static final void main(String[] args){
		try {
			JFrame communication = new Communication("Matthew Damon on Mars");
			communication.setSize(334, 334);
			communication.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There is something wrong with the input file.");
		}
	}
}
