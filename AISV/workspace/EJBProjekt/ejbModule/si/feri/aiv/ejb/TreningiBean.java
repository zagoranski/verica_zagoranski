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
	public Trening najdiId(int id) {
		return em.find(Trening.class, id);
	}

	@Override
	public void shrani(Trening o) {
		em.persist(o);
		
	}

	@Override
	public void uredi(Trening a) {
		  //Trening t= (Trening)em.find(Trening.class,id);
		 em.merge(a);
		
	}

	@Override
	public void izbrisi(int id) {
		Trening t = (Trening)em.find(Trening.class , id);
		em.remove(t); 
		
	}

	@Override
	public List<Trening> vrniVse() {
		return em.createQuery("select o from Trening o").getResultList();
	}


}
