package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import views.Window;

public class Controller implements ActionListener{

	private Window window;
	
	public Controller() {
		window = new Window(this);
	}
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case SHOW_FILE_CHOOSER:
			getFolder();
			break;
		}
	}
	
	private void getFolder() {
		try {
			File folder = window.getFolder();
			System.out.println(folder);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(window, "Por favor escoja  un carpeta", "Advertencia", JOptionPane.WARNING_MESSAGE);
			getFolder();
		}
	}
}