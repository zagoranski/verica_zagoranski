package si.feri.arhitekture;

import javax.ejb.Local;

import javax.ejb.Remote;

@Remote
public interface ZrnceRemote {
	

public double izracun(double teza, double visina);



}
