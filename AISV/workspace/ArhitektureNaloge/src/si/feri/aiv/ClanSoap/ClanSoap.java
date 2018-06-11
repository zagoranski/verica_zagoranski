package si.feri.aiv.ClanSoap;

import java.util.List;


import javax.ejb.EJB;
import javax.jws.WebService;

import si.feri.aiv.ejb.meritve.ClanBean;
import si.feri.aiv.ejb.meritve.ClanDao;
import si.feri.aiv.vao.OsebaClan;

@WebService
public class ClanSoap {

	@EJB
	private ClanDao ejb;

	public List<OsebaClan> vrniVseOsebe() {
		return ejb.vrniVse();
	}

	public void vrniOsebo(int id) {
		ejb.najdiId(id);
	}

	public void dodajOsebo(OsebaClan o) {
		ejb.shrani(o);
	}

	public void spremeni(OsebaClan os){

		 ejb.spremeni(os);
	
	}

	public void izbrisiOsebo(int id) {

			ejb.zbrisi(id);
		
	}

}
