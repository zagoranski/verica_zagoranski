package si.feri.aiv.ejb.meritve;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.feri.aiv.ejb.Treningi;
import si.feri.aiv.vao.Trening;
import si.feri.aiv.vao.OsebaClan;
@Stateless
@Local(ClanDao.class)
public class ClanBean implements ClanDao{
	@PersistenceContext
	EntityManager em;
	@Override
	public OsebaClan najdi(String sifra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OsebaClan najdiId(int id) {
		return em.find(OsebaClan.class, id);
	}

	@Override
	public void shrani(OsebaClan o) {
		em.persist(o);
		
	}

	@Override
	public void spremeni(OsebaClan o) {
		em.persist(o);
		
	}

	@Override
	public void zbrisi(int id) {
		OsebaClan t = (OsebaClan)em.find(OsebaClan.class , id);
		em.remove(t);
		
	}

	@Override
	public List<OsebaClan> vrniVse() {
		return em.createQuery("select o from OsebaClan o").getResultList();
	}

}
