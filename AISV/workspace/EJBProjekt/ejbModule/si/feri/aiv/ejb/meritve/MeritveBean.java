package si.feri.aiv.ejb.meritve;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.feri.aiv.ejb.Treningi;
import si.feri.aiv.vao.Meritev;
import si.feri.aiv.vao.Trening;
//@Stateless
//@Local(MeritveDao.class)
public class MeritveBean{
//	@PersistenceContext
//	EntityManager em;
//
//	@Override
//	public Meritev najdi(String sifra) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Meritev najdiId(int id) {
//		return em.find(Meritev.class, id);
//	}
//
//	@Override
//	public void shrani(Meritev o, String sifra) {
//		o.setSifraUporabnik(sifra);
//		em.persist(o);
//		
//	}
//
//	@Override
//	public void spremeni(int id, Date datum, Double visina, double obseg) {
//		   Meritev t= (Meritev)em.find(Meritev.class ,id);
//		   t.setDatumMeritve(datum);
//		   t.setVisina(visina);
//		   t.setObsegPasu(obseg);
//		
//	}
//
//	@Override
//	public void zbrisi(int id) {
//		Meritev t = (Meritev)em.find(Meritev.class , id);
//		em.remove(t);
//		
//	}
//
//	@Override
//	public List<Meritev> vrniVse() {
//		return em.createQuery("select o from Meritev o").getResultList();
//	}

}
