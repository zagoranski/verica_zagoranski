package si.feri.aiv.jsf;

import java.io.Serializable;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import si.feri.aiv.ejb.Treningi;
import si.feri.aiv.vao.Trening;


@ManagedBean(name="zrno")
@SessionScoped
public class DemoBean implements Serializable{
	
	@EJB
	private Treningi ejb;
	

	private Trening noviTrening=new Trening();

	private Trening izbraniTrening;
	private int idTreninga;
	
	
	private String izbranaSifra;
	
	

	public Trening getNoviTrening() {
		return noviTrening;
	}

	public void setNoviTrening(Trening noviTrening) {
		this.noviTrening = noviTrening;
	}

	public Trening getIzbraniTrening() {
		return izbraniTrening;
	}

	public void setIzbraniTrening(Trening izbraniTrening) {
		this.izbraniTrening = izbraniTrening;
	}

	public String getIzbranaSifra() {
		return izbranaSifra;
	}

	public void setIzbranaSifra(String izbranaSifra) {
		this.izbranaSifra = izbranaSifra;
	}

		
	
	
	
	public void dodajTrening() {
		try {
			ejb.shrani(noviTrening);
			noviTrening=new Trening();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void izbrisi(String id) {
		ejb.izbrisi(Integer.parseInt(id));
		
	}
	Trening trening;
	public void uredi() { 
		izbraniTrening.setId(idTreninga);
		System.out.println("f"  +  "   " + izbraniTrening.getId());
		System.out.println(izbraniTrening);
		ejb.uredi(izbraniTrening);
		
	}
	public void najdiId(int id) {
		idTreninga = id;
		izbraniTrening  = ejb.najdiId(id);
		System.out.println(izbraniTrening + "     jrfidsjfosjfo");
		
	}

	
	public List<Trening> vrniVse() {
		return ejb.vrniVse();
	}

	
}
