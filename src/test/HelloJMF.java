package test;

/*
 * Test chopé à http://www.ee.iitm.ac.in/~tgvenky/JMFBook/Tutorial.pdf
 * pas eu le temps de finir
 */

import javax.swing.*;
import java.awt.*;
import javax.media.*;
import java.awt.event.*;
import java.net.*;

public class HelloJMF {

	JFrame frame = new JFrame(" Hello JMF Player");
	static Player helloJMFPlayer = null;
	//private String path = "C:\Users\SamaHell\Videos\Clip\THE ALGORITHM Trojans.mp4";

	public HelloJMF(){
		try{
			// method using URL
			URL url=new URL("file",null,"hello.wav");
			helloJMFPlayer = Manager.createRealizedPlayer( url);} 
		catch( Exception e) {
			System.out.println(" Unable tocreate the audioPlayer :" + e );
		}	
		
		Component control = helloJMFPlayer.getControlPanelComponent();
		frame.getContentPane().add( control, BorderLayout.CENTER);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				HelloJMF.stop();
				System.exit(0);
			}
		});
		
		frame.pack();
		frame.setSize( new Dimension(200,50) );
		frame.setVisible(true);
		helloJMFPlayer.start();
	}
	
	public static void stop(){
		helloJMFPlayer.stop();
		helloJMFPlayer.close();
	}
	
	public static void main( String args[]){
		HelloJMF helloJMF = new HelloJMF();
	}
} 
