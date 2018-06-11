package si.feri.aiv.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.feri.aiv.vao.Trening;
@Stateless
@Local(Treningi.class)
public class TreningiBean implements Treningi{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Trening najdi(String sifra) {
		return em.find(Trening.class, sifra);
	}

	@Override
	public Trening najdi(int id) {
		return em.find(Trening.class, id);
	}

	@Override
	public void shrani(Trening o) {
		em.persist(o);
		
	}

	@Override
	public void uredi(String sifra, String naziv, String delTelesa, String naprava, String opis, String slika, String video) {
		  Trening t= (Trening)em.find(Trening.class ,sifra);
		   t.setNaziv(naziv);
		   t.setDelTelesa(delTelesa);
		   t.setNaprava(naprava);
		   t.setOpis(opis);
		   t.setSlika(slika);
		   t.setVideo(video);
		
	}

	@Override
	public void izbrisi(String sifra) {
		Trening t = (Trening)em.find(Trening.class ,sifra);
		em.remove(t); 
		
	}

	@Override
	public List<Trening> vrniVse() {
		return em.createQuery("select o from Trening o").getResultList();
	}


}
