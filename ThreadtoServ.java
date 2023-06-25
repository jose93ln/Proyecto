package p1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JTable;
import javax.swing.JTextField;

public class ThreadtoServ extends Thread{
	private DataInputStream input;
	private JTextField textFToDeliver;
	private int message=0;
	
	public ThreadtoServ(DataInputStream _input, JTextField _textFToDeliver) {
		this.input = _input;
		this.textFToDeliver = _textFToDeliver;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("message antes "+message);
				message = input.readInt();
				System.out.println("message despues "+message);
				textFToDeliver.setText(String.valueOf(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
