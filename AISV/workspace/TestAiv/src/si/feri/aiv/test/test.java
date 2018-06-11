package si.feri.aiv.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import si.feri.arhitekture.ZrnceRemote;

public class test {
	@Test
	public void povezavaTest() throws NamingException {
		ZrnceRemote calc;

				calc=(ZrnceRemote)new InitialContext().lookup("EARAiv/EJBProjekt/Zrnce!si.feri.arhitekture.ZrnceRemote");
	
	
	}

}
