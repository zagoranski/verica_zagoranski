package si.feri.arhitekture;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Zrnce
 */
@Stateless
public class Zrnce implements ZrnceLocal, ZrnceRemote {

	@Override
	public double izracun(double teza, double visina) {
		return teza / (Math.sqrt(visina/100));
	}

}
