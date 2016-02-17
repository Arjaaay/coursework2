package xuezhikenichiro;

import java.util.List;

public class Sender extends Thread{
	private final List<Integer> positions;
	private final EventHandler handler;
	Sender(List<Integer> positions, EventHandler handler){
		this.positions = positions;
		this.handler = handler;
	}
	
	@Override
	public void run(){
		try {
			handler.manipulateCamera(positions);
		} catch (InterruptedException e1) {
			System.out.println("The word has been overriden");
		}
	}
}
