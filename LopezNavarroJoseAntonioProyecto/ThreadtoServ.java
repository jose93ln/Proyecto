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
	private boolean bo=true;
	
	public ThreadtoServ(DataInputStream _input, JTextField _textFToDeliver) {
		this.input = _input;
		this.textFToDeliver = _textFToDeliver;
	}
	
	public void run() {
		while(true && bo) {
			try {
				message = input.readInt();
				if(message==999999) {
					bo=false;
				}
				textFToDeliver.setText(String.valueOf(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
