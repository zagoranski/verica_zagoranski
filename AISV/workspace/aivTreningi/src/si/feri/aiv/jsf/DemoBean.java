package si.feri.aiv.jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import si.feri.aiv.ejb.Treningi;
import si.feri.aiv.vao.Trening;


@ManagedBean(name="demo")
@SessionScoped
public class DemoBean {
	
	@EJB
	private Treningi ejb;
	

	private Trening noviTrening=new Trening();

	private Trening izbraniTrening=new Trening();
	
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
	public void izbrisi(String sifra) {
		ejb.izbrisi(sifra);
		
	}
	public void uredi() {
		ejb.uredi(izbraniTrening.getSifraVadbe(), izbraniTrening.getNaziv(), izbraniTrening.getDelTelesa(), izbraniTrening.getNaprava(), izbraniTrening.getOpis(), izbraniTrening.getSlika(), izbraniTrening.getVideo());
		
	}
	public void najdi(String sifra) {
		izbraniTrening  = ejb.najdi(sifra);
		
	}
	
	public List<Trening> vrniVse() {
		return ejb.vrniVse();
	}

}
