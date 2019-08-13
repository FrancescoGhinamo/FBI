package fbi.frontend.mainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import fbi.backend.beam.Crime;
import fbi.backend.beam.CrimeList;
import fbi.backend.beam.Criminal;
import fbi.backend.beam.CriminalList;

public class FBIregGUI extends JFrame implements ActionListener {


	private static final long serialVersionUID = -101249995024720133L;


	private static final String[] CRIME_HEADER = {"Criminal", "Date and time", "Description", "Location"};
	private static final String[] CRIMINAL_HEADER = {"Surname", "Name", "Address", "Birth date", "Fiscal code"};

	private JMenuItem itemAddCrime;
	private JMenuItem itemEditCrime;
	private JMenuItem itemRemoveCrime;
	private JMenuItem itemSaveCrimeList;
	private JMenuItem itemOpenCrimeList;

	private JMenuItem itemAddCriminal;
	private JMenuItem itemEditCriminal;
	private JMenuItem itemRemoveCriminal;
	private JMenuItem itemSaveCriminalList;
	private JMenuItem itemOpenCriminalList;


	private DefaultTableModel crimeMod;
	private JTable crimeTbl;

	private DefaultTableModel criminalMod;
	private JTable criminalTbl;

	public FBIregGUI() {
		super("FBI register");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(500, 300));
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		this.add(initMainPanel(), BorderLayout.CENTER);
		this.setJMenuBar(initJMenuBar());
	}

	private JMenuBar initJMenuBar() {
		JMenuBar bar = new JMenuBar();
		bar.add(initCrimeMenu());
		bar.add(initCriminalMenu());
		return bar;
	}

	private JMenu initCrimeMenu() {
		JMenu mnuCrime = new JMenu("Crime");

		itemAddCrime = new JMenuItem("Add Crime");
		itemAddCrime.addActionListener(this);

		itemEditCrime = new JMenuItem("Edit Crime");
		itemEditCrime.addActionListener(this);

		itemRemoveCrime = new JMenuItem("Remove Crime");
		itemRemoveCrime.addActionListener(this);

		itemSaveCrimeList = new JMenuItem("Save Crime List");
		itemSaveCrimeList.addActionListener(this);

		itemOpenCrimeList = new JMenuItem("Open Crime List");
		itemOpenCrimeList.addActionListener(this);

		mnuCrime.add(itemAddCrime);
		mnuCrime.add(itemEditCrime);
		mnuCrime.add(itemRemoveCrime);
		mnuCrime.addSeparator();
		mnuCrime.add(itemSaveCrimeList);
		mnuCrime.add(itemOpenCrimeList);

		return mnuCrime;
	}

	private JMenu initCriminalMenu() {
		JMenu mnuCriminal = new JMenu("Criminal");

		itemAddCriminal = new JMenuItem("Add Criminal");
		itemAddCriminal.addActionListener(this);

		itemEditCriminal = new JMenuItem("Edit Criminal");
		itemEditCriminal.addActionListener(this);

		itemRemoveCriminal = new JMenuItem("Remove Criminal");
		itemRemoveCriminal.addActionListener(this);

		itemSaveCriminalList = new JMenuItem("Save Criminal List");
		itemSaveCriminalList.addActionListener(this);

		itemOpenCriminalList = new JMenuItem("Open Criminal List");
		itemOpenCriminalList.addActionListener(this);

		mnuCriminal.add(itemAddCriminal);
		mnuCriminal.add(itemEditCriminal);
		mnuCriminal.add(itemRemoveCriminal);
		mnuCriminal.addSeparator();
		mnuCriminal.add(itemSaveCriminalList);
		mnuCriminal.add(itemOpenCriminalList);

		return mnuCriminal;
	}

	private JTabbedPane initMainPanel() {
		JTabbedPane mainPan = new JTabbedPane();

		crimeMod = new DefaultTableModel(CRIME_HEADER, 0);
		crimeTbl = new JTable(crimeMod);
		JScrollPane scrl1 = new JScrollPane(crimeTbl);
		mainPan.addTab("Crimes", scrl1);

		criminalMod = new DefaultTableModel(CRIMINAL_HEADER, 0);
		criminalTbl = new JTable(criminalMod);
		JScrollPane scrl2 = new JScrollPane(criminalTbl);
		mainPan.addTab("Criminals", scrl2);

		return mainPan;		
	}

	public void updateGraphics() {
		crimeMod.setRowCount(0);
		ArrayList<Crime> crimes = CrimeList.getInstance().getContent();
		for(Crime c: crimes) {
			crimeMod.addRow(c.toStringArray());
		}

		criminalMod.setRowCount(0);
		ArrayList<Criminal> criminals = CriminalList.getInstance().getContent();
		for(Criminal c: criminals) {
			criminalMod.addRow(c.toStringArray());
		}


	}
	
	public JFileChooser initCrimeFileChooser() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Crime list", CrimeList.EXTENSION));
		return fc;
	}

	public void performAddCrime() {

	}

	public void performEditCrime() {

	}

	public void performRemoveCrime() {

	}

	public void performSaveCrimeList() {
		JFileChooser fc = initCrimeFileChooser();
		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			if(path.endsWith(CrimeList.EXTENSION)) {
				path += CrimeList.EXTENSION;
			}
			CrimeList.getInstance().serialize(path);
		}
	}

	public void performOpenCrimeList() {
		JFileChooser fc = initCrimeFileChooser();
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			CrimeList.getInstance(path);
			updateGraphics();
		}
	}
	
	
	
	
	
	
	public JFileChooser initCriminalFileChooser() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Criminal list", CriminalList.EXTENSION));
		return fc;
	}

	public void performAddCriminal() {

	}

	public void performEditCriminal() {

	}

	public void performRemoveCriminal() {

	}

	public void performSaveCriminalList() {
		JFileChooser fc = initCriminalFileChooser();
		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			if(path.endsWith(CriminalList.EXTENSION)) {
				path += CriminalList.EXTENSION;
			}
			CriminalList.getInstance().serialize(path);
		}
	}

	public void performOpenCriminalList() {
		JFileChooser fc = initCriminalFileChooser();
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			CriminalList.getInstance(path);
			updateGraphics();
		}
	}

	@Override
	public void actionPerformed(ActionEvent aE) {
		if(aE.getSource().equals(itemAddCrime)) {
			performAddCrime();
		}
		else if(aE.getSource().equals(itemEditCrime)) {
			performEditCrime();
		}
		else if(aE.getSource().equals(itemRemoveCrime)) {
			performRemoveCrime();
		}
		else if(aE.getSource().equals(itemSaveCrimeList)) {
			performSaveCrimeList();
		}
		else if(aE.getSource().equals(itemOpenCrimeList)) {
			performOpenCrimeList();
		}
		else if(aE.getSource().equals(itemAddCriminal)) {
			performAddCriminal();
		}
		else if(aE.getSource().equals(itemEditCriminal)) {
			performEditCriminal();
		}
		else if(aE.getSource().equals(itemRemoveCriminal)) {
			performRemoveCriminal();
		}
		else if(aE.getSource().equals(itemSaveCriminalList)) {
			performSaveCriminalList();
		}
		else if(aE.getSource().equals(itemOpenCriminalList)) {
			performOpenCriminalList();
		}

	}

	public static void main(String[] args) {
		new FBIregGUI().setVisible(true);
	}

}
