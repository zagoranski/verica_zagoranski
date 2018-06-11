package si.feri.arhitekture;

import javax.ejb.Local;

@Local
public interface ZrnceLocal {

	public double izracun(double teza, double visina);
}
