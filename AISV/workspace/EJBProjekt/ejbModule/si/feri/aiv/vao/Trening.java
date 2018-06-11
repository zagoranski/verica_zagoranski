package si.feri.aiv.vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trening { 
	private int id;
	private String naziv;
	private String sifraVadbe;
	private String delTelesa;
    private String naprava;
    private String opis;
    private String slika;
    private String video;
    
    public Trening() {
	}
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trening(String naziv, String sifraVadbe, String delTelesa, String naprava, String opis, String slika,
			String video) {
		super();
		this.naziv = naziv;
		this.sifraVadbe = sifraVadbe;
		this.delTelesa = delTelesa;
		this.naprava = naprava;
		this.opis = opis;
		this.slika = slika;
		this.video = video;
	}
    
    public Trening(String naziv, String sifraVadbe, String delTelesa, String naprava, String opis, String slika,
			String video, int id) {
		super();
		this.naziv = naziv;
		this.sifraVadbe = sifraVadbe;
		this.delTelesa = delTelesa;
		this.naprava = naprava;
		this.opis = opis;
		this.slika = slika;
		this.video = video;
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getSifraVadbe() {
		return sifraVadbe;
	}


	public void setSifraVadbe(String sifraVadbe) {
		this.sifraVadbe = sifraVadbe;
	}


	public String getDelTelesa() {
		return delTelesa;
	}


	public void setDelTelesa(String delTelesa) {
		this.delTelesa = delTelesa;
	}


	public String getNaprava() {
		return naprava;
	}


	public void setNaprava(String naprava) {
		this.naprava = naprava;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public String getSlika() {
		return slika;
	}


	public void setSlika(String slika) {
		this.slika = slika;
	}


	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}
    
    
    
    
}
