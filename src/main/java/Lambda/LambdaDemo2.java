package Lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LambdaDemo2 {



	public static void main(String[] a) {
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("without lambda expression is boring");
			}
		});
		
		show.addActionListener(arg -> {
			System.out.println("lambda is nb!");
			});
	}
	
}
