
import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.model.chart.*;

import si.feri.arhitekture.Zrnce;
import si.feri.arhitekture.ZrnceLocal;

@ManagedBean(name="demo")
@SessionScoped
public class PrvaNaloga{
	
	public PrvaNaloga() {

	}
	private OsebaClan izbranaOseba = new OsebaClan();
	private Meritve meritve=new Meritve();
	private Meritve izbranaMeritev=new Meritve();
	private LineChartModel graf;
	public void setGraf(LineChartModel graf) {
		this.graf = graf;
	}
	public LineChartModel getGraf() {
		return this.graf;
	}

	public Meritve getIzbranaMeritev() {
		return izbranaMeritev;
	}

	public void setIzbranaMeritev(Meritve izbraneMeritve) {
		this.izbranaMeritev = izbraneMeritve;
	}

//	private MeritveDao meritveDao = new MeritveDao();
//	private ÈlanDao dao = new ÈlanDao();
	public OsebaClan getIzbranaOseba() {
		return izbranaOseba;
	}

	public void setIzbranaOseba(OsebaClan izbranaOseba) {
		this.izbranaOseba = izbranaOseba;
	}

	private OsebaClan novaOseba=new OsebaClan();
	public OsebaClan getNovaOseba() {
		return novaOseba;
	}

	public void setNovaOseba(OsebaClan novaOseba) {
		this.novaOseba = novaOseba;
	}

	public Meritve getMeritve() {
		return meritve;
	}

	public void setMeritve(Meritve meritve) {
		this.meritve = meritve;
	}
	  public ArrayList getCla() {
			return cla;
		}
		  public void setCla(ArrayList cla) {
			this.cla = cla;
		}

//	public ArrayList<Èlani> clani = new ArrayList();
//	public ArrayList<Meritve> vseMeritve = new ArrayList();

    public void dodajOsebo() {
    	System.out.println("djsaojdoasjdoa");
//    	clani.add(novaOseba);
//    	vseMeritve.add(meritve);
//    	novaOseba = new Èlani();
//    	meritve = new Meritve();
    	try {
			ÈlanDao.getInstance().shrani(novaOseba);
			MeritveDao.getInstance().shrani(meritve, novaOseba.getSifra());
			meritve = new Meritve();
			novaOseba=new OsebaClan();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void urediMeritev() {
    	try {
			MeritveDao.getInstance().spremeni(izbranaMeritev, izbranaOseba.getSifra());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void urediOsebo() {
    	try {
			ÈlanDao.getInstance().spremeni(izbranaOseba, izbranaOseba.getSifra());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
//    public ArrayList getClani() {
//    	return clani;
//    }
    public void izberiOsebo(String sifra) {
		try {
			izbranaOseba=ÈlanDao.getInstance().najdi(sifra);
			izbranaOseba.setMeritve(MeritveDao.getInstance().vrniVse(sifra));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public String izberiMeritev(Date datum) {
		try {
			izbranaMeritev=MeritveDao.getInstance().najdi(datum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "urediMeritev.xhtml";
	}
    
    public String izberiOseboUporabnik(String sifra) {
  		try {
  			izbranaOseba=ÈlanDao.getInstance().najdi(sifra);
  			izbranaOseba.setMeritve(MeritveDao.getInstance().vrniVse(sifra));
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return "uporabnikPodrobnosti.xhtml";
  	}
    private ArrayList<OsebaClan> cla;
    public ArrayList<OsebaClan> vseOsebe() throws Exception{
    	cla = new ArrayList();
    	for(int i = 0; i < ÈlanDao.getInstance().vrniVse().size(); i++) {
    		cla.add((OsebaClan) ÈlanDao.getInstance().vrniVse().get(i));	
    	}
    	return cla;
    }

  public void dodajMeritev() {
  	try {
			MeritveDao.getInstance().shrani(meritve, izbranaOseba.getSifra());
			meritve = new Meritve();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  public String izbrisiOsebo(String sifra) {
	  try {
			ÈlanDao.getInstance().zbrisi(sifra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return "seznam.xhtml";
	  }
  public String izbrisiMeritev(Date datum, String sifra) {
	  try {
			MeritveDao.getInstance().zbrisi(datum, sifra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return "seznam.xhtml";
	  }
//  public ArrayList<Meritve> iterator(Date od, Date doo) {
//	  ArrayList<Meritve> meritve = new ArrayList();
//	  Iterator<Meritve> iterator=(Iterator<Meritve>) izbranaOseba.getMeritve();
//	  while (iterator.hasNext()) {
//		    Meritve mer = iterator.next();
//		    if (mer.getDatumMeritve().after(od) && mer.getDatumMeritve().before(doo)) {
//		      meritve.add(mer);
//		    }
//		}
//	  return meritve;
//  }
  public LineChartModel initLinearModel() {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      LineChartModel model = new LineChartModel();
      LineChartSeries series1 = new LineChartSeries();
      series1.setLabel("Series 1");
      Date datum;
      double teza = 0;
      for(int i = 0; i<izbranaOseba.getMeritve().size(); i++) {
    	  datum = izbranaOseba.getMeritve().get(i).getDatumMeritve();
    	  teza = izbranaOseba.getMeritve().get(i).getTeza();
       	  System.out.println(datum + "  " + teza);
    	  series1.set(datum,teza);
      }
     model.addSeries(series1);
      
     return model;	 
 }
  public void createLineModels() {
      graf = initLinearModel();
      graf.setTitle("Linear Chart");
      graf.setAnimate(true);
      graf.setLegendPosition("e");
      graf.getAxis(AxisType.Y).setLabel("Values");
      DateAxis axis = new DateAxis("Dates");
      axis.setTickAngle(-50);
      axis.setMax("2014-02-01");
      axis.setTickFormat("%b %#d, %y");
       
      graf.getAxes().put(AxisType.X, axis);
  }
@EJB
ZrnceLocal ejb;
  public LineChartModel initLinearModel2() {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      LineChartModel model = new LineChartModel();
      LineChartSeries series1 = new LineChartSeries();
      series1.setLabel("Series 1");
      Date datum;
      double itm = 0;
      double teza = 0;
      for(int i = 0; i<izbranaOseba.getMeritve().size(); i++) {
    	  datum = izbranaOseba.getMeritve().get(i).getDatumMeritve();
    	  teza = izbranaOseba.getMeritve().get(i).getTeza();
    	 itm = ejb.izracun(teza, izbranaOseba.getMeritve().get(i).getVisina());
    	  //itm =  teza / (Math.sqrt(izbranaOseba.getMeritve().get(i).getVisina()/100));
       	  System.out.println(datum + "  " + itm);
    	  series1.set(datum,itm);
      }
     model.addSeries(series1);
      
     return model;	 
 }
  public void createLineModels2() {
      graf = initLinearModel2();
      graf.setTitle("Linear Chart");
      graf.setAnimate(true);
      graf.setLegendPosition("e");
      graf.getAxis(AxisType.Y).setLabel("Values");
      DateAxis axis = new DateAxis("Dates");
      axis.setTickAngle(-50);
      axis.setMax("2014-02-01");
      axis.setTickFormat("%b %#d, %y");
       
      graf.getAxes().put(AxisType.X, axis);
  }
  
  public LineChartModel initLinearModel3() {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      LineChartModel model = new LineChartModel();
      LineChartSeries series1 = new LineChartSeries();
      series1.setLabel("Series 1");
      Date datum;
      double itm = 0;
      double teza = 0;
      Iterator<Meritve> iterator=grafDatumi();
      Meritve m;
		while (!iterator.hasNext()) {
			 m=iterator.next();
			 datum = m.getDatumMeritve();
	    	 teza =m.getTeza();
	    	 //itm =  ejb.izracun(teza, iterator.next().getVisina()); 
	    	 itm =  teza / (Math.sqrt(iterator.next().getVisina()/100));
	    	  series1.set(datum,itm);
		}
     model.addSeries(series1);
      
     return model;	 
 }
  public void createLineModels3() {
      graf = initLinearModel3();
      graf.setTitle("Linear Chart");
      graf.setAnimate(true);
      graf.setLegendPosition("e");
      graf.getAxis(AxisType.Y).setLabel("Values");
      DateAxis axis = new DateAxis("Dates");
      axis.setTickAngle(-50);
      axis.setMax("2014-02-01");
      axis.setTickFormat("%b %#d, %y");
       
      graf.getAxes().put(AxisType.X, axis);
  }
  public LineChartModel initLinearModel4() {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      LineChartModel model = new LineChartModel();
      LineChartSeries series1 = new LineChartSeries();
      series1.setLabel("Series 1");
      Date datum;
      double itm = 0;
      double teza = 0;
      Iterator<Meritve> iterator=grafDatumi();
      Meritve m;
		while (!iterator.hasNext()) {
			  m=iterator.next();
			  datum =m.getDatumMeritve();
	    	  teza =m.getTeza();
	    	  series1.set(datum,teza);
		}
     model.addSeries(series1);
      
     return model;	 
 }
  public void createLineModels4() {
      graf = initLinearModel3();
      graf.setTitle("Linear Chart");
      graf.setAnimate(true);
      graf.setLegendPosition("e");
      graf.getAxis(AxisType.Y).setLabel("Values");
      DateAxis axis = new DateAxis("Dates");
      axis.setTickAngle(-50);
      axis.setMax("2014-02-01");
      axis.setTickFormat("%b %#d, %y");
       
      graf.getAxes().put(AxisType.X, axis);
  }
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  public Iterator<Meritve> grafDatumi() {
      Iterator<Meritve> it = new Iterator<Meritve>() {
    	  private ArrayList<Meritve> c=new ArrayList<>(izbranaOseba.getMeritve());
          private int curr = -1;

          @Override
          public boolean hasNext() {
        	 curr++;
        	 String datum = sdf.format( meritve.getOd());
        	 String dat = sdf.format( meritve.getDoo());
        	  //System.out.println(c.get(curr).getDatumMeritve() + "  " + c.get(curr).getDatumMeritve() + "   " + curr + "  " + java.sql.Date.valueOf(datum)+ "   " + java.sql.Date.valueOf(dat));
        		if (curr<c.size()){
        			if(c.get(curr).getDatumMeritve().after(java.sql.Date.valueOf(datum)) && c.get(curr).getDatumMeritve().before(java.sql.Date.valueOf(dat))) {	
        			//System.out.println(c.get(curr).getDatumMeritve() + "  " + c.get(curr).getDatumMeritve());
					return false;
        			
        		}
				}
				return true;
			}

          @Override
          public Meritve next() {
				return c.get(curr);
          }
//
      };
      return it;
  }
  paket p;
  public void izberiPaket(Date datumOd, String paket, String mail) {
	  dodajOsebo();
	  String ispis;
	  if(paket.equals("Mesecni paket")) {
		  p = new mesecniPaket();
		  String m = "praktikumekd@gmail.com";
		  String g="praktikumEKD1997";
		  //String mail = novaOseba.getMail();
		  Date datumDo = new Date();
		  Calendar myCal = Calendar.getInstance();
		      myCal.setTime(datumOd);    
		  myCal.add(Calendar.MONTH, +1);    
		  datumDo = myCal.getTime();
		  String obvestilo = "Izbrali ste meseèni paket, paket velja od" + datumOd + "do" + datumDo;
			
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(m,g);
					}
				});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(m));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail));
				message.setSubject("Registracija");
				message.setText(obvestilo);

				Transport.send(message);

				

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			System.out.println(ispis = p.izbira());
	  }else if(paket.equals("Letni paket")) {
		  p = new letniPaket();
		  String m = "praktikumekd@gmail.com";
		  String g="praktikumEKD1997";
		  //String mail = novaOseba.getMail();
		  Date datumDo = new Date();
		  Calendar myCal = Calendar.getInstance();
		      myCal.setTime(datumOd);    
		  myCal.add(Calendar.YEAR, +1);    
		  datumDo = myCal.getTime();
		  String obvestilo = "Izbrali ste letni paket, paket velja od" + datumOd + "do" + datumDo;
			
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(m,g);
					}
				});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(m));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail));
				message.setSubject("Registracija");
				message.setText(obvestilo);

				Transport.send(message);

				

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			System.out.println(ispis = p.izbira());
		  
	  }else {
		  System.out.println("Izbran je obstojeè paket.");
	  }
		  
	} 
	

// U ÈLAN SI DODALA MAIL i paket, TREBAS PROMIJENITI U BAZI ua update...


  
 
    

}
