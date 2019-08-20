package fbi.frontend.dialogs;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datePicker.JDatePicker;
import fbi.backend.beam.Crime;
import fbi.backend.beam.CriminalList;

public class CrimeDialog extends JDialog implements ActionListener {

	
	private static final long serialVersionUID = -7083895357574079701L;
	
	private JTextField txtCriminalFC;
	private JDatePicker dpDate;
	private JTextField txtTime;
	private JTextField txtDescription;
	private JTextField txtLocation;
	
	private JButton btnOK;
	private JButton btnCancel;
	
	private Crime crime;
	
	public CrimeDialog(JFrame owner, boolean modale, String criminalFC) {
		super(owner, "Crime", modale);
		initComponents();
		pack();
		crime = null;
		txtCriminalFC.setText(criminalFC);
		
	}
	
	public CrimeDialog(JFrame owner, boolean modale, Crime source) {
		this(owner, modale, "");
		writeComponents(source);
	}

	private void writeComponents(Crime s) {
		txtCriminalFC.setText(s.getCriminal().getFiscalCode());
		dpDate.setDate(s.getDateTime());
		txtTime.setText(s.getDateTime().get(GregorianCalendar.HOUR_OF_DAY) + ":" + s.getDateTime().get(GregorianCalendar.MINUTE));
		txtDescription.setText(s.getDescription());
		txtLocation.setText(s.getLocation());
		crime = s;
		
	}

	private void initComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 10;
		gbc.weighty = 10;
		gbc.insets = new Insets(5, 5, 5, 5);
		this.add(initFieldPanel(), gbc);
		
		
		gbc.gridy = 1;
		gbc.weightx = 10;
		gbc.weighty = 3;
		this.add(initButPanel(), gbc);
		
		
	}
	
	
	private JPanel initFieldPanel() {
		JPanel pan = new JPanel(new GridLayout(5, 2, 3, 3));
		pan.add(new JLabel("Criminal FC:"));
		pan.add(txtCriminalFC = new JTextField(20));
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		pan.add(new JLabel("Date:"));
		pan.add(dpDate = new JDatePicker(p));
		pan.add(new JLabel("Time (HH:mm):"));
		pan.add(txtTime = new JTextField(20));
		pan.add(new JLabel("Description:"));
		pan.add(txtDescription = new JTextField(20));		
		pan.add(new JLabel("Location:"));
		pan.add(txtLocation = new JTextField(20));
		return pan;
	}
	
	private JPanel initButPanel() {
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		pan.add(btnCancel);
		pan.add(btnOK);
		return pan;
	}
	
	private void performOK() {
		if(!txtCriminalFC.getText().equals("") && !txtTime.getText().equals("") && !txtDescription.getText().equals("") && !txtLocation.getText().equals("")) {
			GregorianCalendar dateTime = dpDate.getDate();
			try {
				String[] parts = txtTime.getText().split(":");
				dateTime.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
				dateTime.set(GregorianCalendar.MINUTE, Integer.parseInt(parts[1]));
				crime = new Crime(CriminalList.getInstance().get(txtCriminalFC.getText()), dateTime, txtDescription.getText(), txtLocation.getText());
				dispose();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "You must fill in all the information", "Information missing", JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK)) {
			performOK();
		}
		else if(e.getSource().equals(btnCancel)) {
			dispose();
		}

	}

	public Crime getCrime() {
		return crime;
	}
	
	

}
