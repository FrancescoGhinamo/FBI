package fbi.frontend.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import datePicker.JDatePicker;
import fbi.backend.beam.Criminal;

public class CriminalDialog extends JDialog implements ActionListener {

	
	private static final long serialVersionUID = 7454803225483887864L;
	
	private JTextField txtSurname;
	private JTextField txtName;
	private JTextField txtAddress;
	private JDatePicker dpBirth;
	private JTextField txtFiscalCode;
	private JLabel lblPicture;
	private File picture;
	
	private JButton btnChoosePicture;
	private JButton btnCancel;
	private JButton btnOK;
	
	private Criminal criminal;
	
	public CriminalDialog(JFrame owner, boolean modale) {
		super(owner, "Criminal", modale);
		initComponents();
		pack();
		criminal = null;
		picture = null;
		
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
		
		this.add(initPicPanel(), gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 15;
		gbc.weighty = 15;
		this.add(initFieldPanel(), gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 3;
		this.add(initButPanel(), gbc);
		
	}
	
	private JPanel initFieldPanel() {
		JPanel pan = new JPanel(new GridLayout(5, 2, 3, 3));
		pan.add(new JLabel("Surname:"));
		pan.add(txtSurname = new JTextField(20));
		pan.add(new JLabel("Name:"));
		pan.add(txtName = new JTextField(20));
		pan.add(new JLabel("Address:"));
		pan.add(txtAddress = new JTextField(20));
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		pan.add(new JLabel("Birth date:"));
		pan.add(dpBirth = new JDatePicker(p));
		pan.add(new JLabel("Fiscal code:"));
		pan.add(txtFiscalCode = new JTextField(20));
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
	
	private JPanel initPicPanel() {
		JPanel pan = new JPanel(new BorderLayout());
		pan.add(lblPicture = new JLabel(), BorderLayout.CENTER);
		
		btnChoosePicture = new JButton("Choose picture");
		btnChoosePicture.addActionListener(this);
		pan.add(btnChoosePicture, BorderLayout.SOUTH);
		
		return pan;
		
	}
	
	public JFileChooser initFileChooser() {
		JFileChooser fC = new JFileChooser();
		fC.setFileFilter(new FileNameExtensionFilter(".jpg, .png, .gif, .bmp", "jpg", "png", "gif", "bmp"));
		return fC;
	}

	private void performChoosePicture() {
		JFileChooser fc = initFileChooser();
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			picture = fc.getSelectedFile();
			ImageIcon i = new ImageIcon(picture.getAbsolutePath());
			lblPicture.setIcon(i);
		}
	}
	
	private void performOK() {
		if(!txtSurname.getText().equals("") && !txtName.getText().equals("") && !txtAddress.getText().equals("") && !txtFiscalCode.getText().equals("") && picture != null) {
			criminal = new Criminal(txtSurname.getText(), txtName.getText(), txtAddress.getText(), dpBirth.getDate(), txtFiscalCode.getText(), picture);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "You must fill in all the information", "Information missing", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnChoosePicture)) {
			performChoosePicture();
		}
		else if(e.getSource().equals(btnOK)) {
			performOK();
		}
		else if(e.getSource().equals(btnCancel)) {
			dispose();
		}

	}

	public Criminal getCriminal() {
		return criminal;
	}
	
	

}
