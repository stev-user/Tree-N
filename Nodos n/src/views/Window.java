package views;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import controllers.Actions;
import controllers.Controller;
import model.entities.MyFile;

public class Window extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	
	public Window(Controller controller) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("Archivo");
		
		JMenuItem itemOpen = new JMenuItem("Abrir carpeta");
		itemOpen.addActionListener(controller);
		itemOpen.setActionCommand(Actions.SHOW_FILE_CHOOSER.toString());
		menuFile.add(itemOpen);
		
		menuBar.add(menuFile);
		
		setJMenuBar(menuBar);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Nombre", "Extension"});
		
		table = new JTable(model);
		
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void showTable(ArrayList<MyFile> files){
		model.setRowCount(0);
		for (MyFile myFile : files) {
			model.addRow(myFile.toVector());
		}
	}
	
	public File getFolder() throws Exception{
		JFileChooser jf = new JFileChooser();
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = jf.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			return jf.getSelectedFile();
		}
		throw new Exception();
	}
}