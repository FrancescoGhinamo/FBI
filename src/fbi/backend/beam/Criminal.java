package fbi.backend.beam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Criminal {

	private String surname;
	private String name;
	private String address;
	private GregorianCalendar birthDate;
	private String fiscalCode;
	private File picture;
	
	
	
	
	public Criminal(String surname, String name, String address, GregorianCalendar birthDate, String fiscalCode,
			File picture) {
		super();
		this.surname = surname;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.fiscalCode = fiscalCode;
		this.picture = picture;
	}
	
	public String[] toStringArray() {
		
		String[] data = new String[5];
		
		data[0] = surname;
		data[1] = name;
		data[2] = address;
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
		data[3] = fmt.format(birthDate.getTime());
		data[4] = fiscalCode;
		
		
		return data;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	
	
	
}
