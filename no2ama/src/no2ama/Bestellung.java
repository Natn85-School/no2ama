package no2ama;

public class Bestellung
{
	private Artikel artikel;
	private String kundenname;
	
	public Bestellung(String kundenname, Artikel artikel)
	{
		this.kundenname = kundenname;
		this.artikel = artikel;
	}

	public Artikel getArtikel()
	{
		return artikel;
	}

	public void setArtikel(Artikel artikel)
	{
		this.artikel = artikel;
	}

	public String getKundenname()
	{
		return kundenname;
	}

	public void setKundenname(String kundenname)
	{
		this.kundenname = kundenname;
	}
}