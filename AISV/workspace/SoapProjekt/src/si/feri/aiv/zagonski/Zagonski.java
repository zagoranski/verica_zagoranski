package si.feri.aiv.zagonski;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import si.feri.aiv.clansoap.ClanSoap;
import si.feri.aiv.clansoap.ClanSoapService;
import si.feri.aiv.clansoap.OsebaClan;

public class Zagonski {

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException {
		ClanSoap os=new ClanSoapService().getClanSoapPort();
		OsebaClan o= new OsebaClan();
		o.setIme("Verica");
		o.setPriimek("Zagoranski");
		o.setSpol("zenski");
		o.setSifra("7968412");
		
		String datum = "02/12/1997";
		Date d = new SimpleDateFormat("MM/dd/yyyy").parse(datum);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		
		o.setDatum(date);
		SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
		Date datumVpisa = new Date();
		String datumV = s.format(datumVpisa);
		Date dV = new SimpleDateFormat("MM/dd/yyyy").parse(datumV);
		cal.setTime(dV);
		XMLGregorianCalendar dat = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		
		
		o.setDatumVpisa(dat);
		o.setMail("venfasjlfnsa@");
		os.dodajOsebo(o);
		
		for (OsebaClan oseba : os.vrniVseOsebe()) {
			System.out.println(oseba.getPriimek() + " "+oseba.getIme());
		}

	}

}
