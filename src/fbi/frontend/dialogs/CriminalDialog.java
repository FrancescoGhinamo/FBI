package fbi.frontend.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datePicker.JDatePicker;

public class CriminalDialog extends JDialog implements ActionListener {

	
	private static final long serialVersionUID = 7454803225483887864L;
	
	private JTextField txtSurname;
	private JTextField txtName;
	private JTextField txtAddress;
	private JDatePicker dpBirth;
	private JTextField txtFiscalCode;
	private JLabel lblPicture;
	
	private JButton btnChoosePicture;
	private JButton btnCancel;
	private JButton btnOK;
	
	public CriminalDialog(JFrame owner, boolean modale) {
		super(owner, "Criminal", modale);
		initComponents();
		pack();
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		//vedere grafica nel file sul desktop
	}
	
	private JPanel initFieldPanel() {
		JPanel pan = new JPanel(new GridLayout(5, 2, 3, 3));
		
		return pan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
