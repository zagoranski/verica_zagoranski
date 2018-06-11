package si.feri.aiv.ejb.meritve;

import java.util.Date;
import java.util.List;

import si.feri.aiv.vao.Meritev;
public interface MeritveDao {
    Meritev najdi(String sifra);
	
	Meritev najdiId(int id);

	void shrani(Meritev o, String sifraUporabnik);
	void spremeni(int id, Date datum, Double visina, double obseg);
	void zbrisi(int id);

	List<Meritev> vrniVse();

}
