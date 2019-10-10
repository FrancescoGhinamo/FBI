package fbi.backend.beam;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import fbi.backend.service.FileServiceFactory;
import fbi.backend.service.IFileService;

public class CriminalList extends Hashtable<String, Criminal> {

	
	private static final long serialVersionUID = -7822474012882055793L;
	public static final String EXTENSION = "cll";
	
	private static CriminalList me;
	
	private CriminalList() {
		super();
	}
	
	public void put(Criminal c) {
		super.put(c.getFiscalCode(), c);
	}
	
	public static CriminalList getInstance() {
		if(me == null) {
			me = new CriminalList();
		}
		return me;
	}
	
	public static CriminalList getInstance(String source) {
		IFileService fS = FileServiceFactory.getFileService();
		me = (CriminalList) fS.deserialize(source);
		return me;
	}
	
	public ArrayList<Criminal> getContent() {
		ArrayList<Criminal> crims = new ArrayList<Criminal>();
		Set<String> ks = this.keySet();
		for(String k: ks) {
			crims.add(me.get(k));
		}
		
		return crims;
	}
	
	public void serialize(String dest) {
		IFileService fS = FileServiceFactory.getFileService();
		fS.serialize(dest, me);
	}

}
