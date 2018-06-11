package si.feri.aiv.ejb;

import java.util.List;



import si.feri.aiv.vao.Trening;

public interface Treningi {
	
	Trening najdiId(int id);

	void shrani(Trening o);
	//void uredi(int id, String naziv, String delTelesa, String naprava, String opis, String slika, String video);
	void izbrisi(int id);

	List<Trening> vrniVse();

	void uredi(Trening a);

}
