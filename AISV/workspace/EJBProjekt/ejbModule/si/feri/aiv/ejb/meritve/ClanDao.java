package si.feri.aiv.ejb.meritve;

import java.util.Date;
import java.util.List;
import si.feri.aiv.vao.OsebaClan;
public interface ClanDao {
	    OsebaClan najdi(String sifra);
		
		OsebaClan najdiId(int id);

		void shrani(OsebaClan o);
		void spremeni(OsebaClan o);
		void zbrisi(int id);

		List<OsebaClan> vrniVse();
}
