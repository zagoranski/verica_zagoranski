import java.text.SimpleDateFormat;



//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.Date;

public class Meritve {
	private Date datumMeritve;
	private double visina;
	private double obsegPasu;
	private Date od;
	private Date doo;
	public Date getOd() {
		return od;
	}


	public void setOd(Date od) {
		this.od = od;
	}


	public Date getDoo() {
		return doo;
	}


	public void setDoo(Date doo) {
		this.doo = doo;
	}


	public Meritve(Date datumMeritve, double visina, double obsegPasu, double teza) {
		super();
		this.datumMeritve=datumMeritve;
		this.visina = visina;
		this.obsegPasu = obsegPasu;
		this.teza = teza;
	}
	private double teza;
	
    public Meritve() {
		
	}


	public Date getDatumMeritve() {
		return datumMeritve;
	}

	public void setDatumMeritve(Date datumMeritve) {
		this.datumMeritve = datumMeritve;
	}

	public double getVisina() {
		return visina;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}

	public double getObsegPasu() {
		return obsegPasu;
	}

	public void setObsegPasu(double obsegPasu) {
		this.obsegPasu = obsegPasu;
	}

	public double getTeza() {
		return teza;
	}

	public void setTeza(double teza) {
		this.teza = teza;
	}
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	

}
