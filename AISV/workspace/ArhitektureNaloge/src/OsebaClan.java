import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.Date;

public class OsebaClan {
	private String ime;
	private String priimek;
	private String spol;
	private Date datum;
	private Date datumVpisa;
	private String sifra;
	private String mail;
	private String paket;
	public String getPaket() {
		return paket;
	}


	public void setPaket(String paket) {
		this.paket = paket;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	private ArrayList<Meritve> meritve = new ArrayList();
	
	public ArrayList<Meritve> getMeritve() {
		return meritve;
	}


	public OsebaClan(String ime, String priimek, String spol, Date datum, Date datumVpisa, String sifra) {
		super();
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.datum=datum;
		this.datumVpisa=datumVpisa;
		this.sifra = sifra;
	}


	public void setMeritve(ArrayList<Meritve> meritve) {
		this.meritve = meritve;
	}


	public OsebaClan() {
		
	}

	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPriimek() {
		return priimek;
	}


	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}


	public String getSpol() {
		return spol;
	}


	public void setSpol(String spol) {
		this.spol = spol;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Date getDatumVpisa() {
		return datumVpisa;
	}


	public void setDatumVpisa(Date datumVpisa) {
		this.datumVpisa = datumVpisa;
	}


	public String getSifra() {
		return sifra;
	}


	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	

}
