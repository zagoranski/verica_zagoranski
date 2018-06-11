package si.feri.aiv.ejb;

import java.util.List;

import si.feri.aiv.vao.Trening;

public interface Treningi {
    Trening najdi(String sifra);
	
	Trening najdi(int id);

	void shrani(Trening o);
	void uredi(String sifra, String naziv, String delTelesa, String naprava, String opis, String slika, String video);
	void izbrisi(String sifra);

	List<Trening> vrniVse();

}
