package fbi.backend.beam;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Set;

import fbi.backend.service.FileServiceFactory;
import fbi.backend.service.IFileService;

public class CrimeList extends Hashtable<GregorianCalendar, Crime> {


	private static final long serialVersionUID = 7710923749022241740L;

	private static CrimeList me;

	private CrimeList() {
		super();
	}

	public static CrimeList getInstance() {
		if(me == null) {
			me = new CrimeList();
		}
		return me;
	}

	public static CrimeList getInstance(String source) {
		IFileService fS = FileServiceFactory.getFileService();
		me = (CrimeList) fS.deserialize(source);
		return me;
	}

	public ArrayList<Crime> getContent() {
		ArrayList<Crime> crims = new ArrayList<Crime>();
		Set<GregorianCalendar> ks = this.keySet();
		for(GregorianCalendar k: ks) {
			crims.add(me.get(k));
		}

		return crims;
	}

	public void serialize(String dest) {
		IFileService fS = FileServiceFactory.getFileService();
		fS.serialize(dest, me);
	}
}
