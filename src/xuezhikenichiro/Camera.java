package xuezhikenichiro;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Camera extends JSlider{	
	private static final long serialVersionUID = -3116842279769419928L;

	/**
	 * Sets up all the arrangements which are assumed to be fixed.
	 * @param n The number of ticks that represent positions the camera points to.
	 */
	public Camera(int n){
		setValue(0);
		setMinimum(0);
		setMaximum(n - 1);
		setPaintLabels(true);
		Dictionary<Integer, JComponent> labels = new Hashtable<>();
		for(int i = 0; i < n; i++){
			if(i < 10){
				labels.put(i, new JLabel(Integer.toString(i)));
			}else{
				char label = (char)('a' + i - 10);
				labels.put(i, new JLabel(Character.toString(label)));
			}
		}
		setLabelTable(labels);
	}
	/**
	 * Manipulates the slider so that it indicates each position sequentially and wait for the specified space of time.
	 * On top of that, it takes a while to complete this method especially the size of the position list is big. That is why the called is required to handle InterruptedException.
	 * 
	 * @param positions sequence of integers that represents the given word.
	 * @param interval the length of time to sleep in milliseconds.
	 * 
	 * @throw InterruptedException if any thread has interrupted the current thread.
	 */
	public void pointsTo(List<Integer> positions, long interval, Terminable callback) throws InterruptedException{
		for(int position : positions){
			setValue(position);
			java.awt.Toolkit.getDefaultToolkit().beep();
			Thread.sleep(interval);
		}
		callback.onTerminate();
	}
}
