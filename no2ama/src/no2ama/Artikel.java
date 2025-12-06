package no2ama;

public class Artikel
{
	private int artikelNummer;
	private String artikelBezeichnung;
	private double preis;
	
	public Artikel(int artikelNummer, String artikelBezeichnung, double preis)
	{
		this.artikelNummer = artikelNummer;
		this.artikelBezeichnung = artikelBezeichnung;
		this.preis = preis;	
	}

	public int getArtikelNummer()
	{
		return artikelNummer;
	}

	public void setArtikelNummer(int artikelNummer)
	{
		this.artikelNummer = artikelNummer;
	}

	public String getArtikelBezeichnung()
	{
		return artikelBezeichnung;
	}

	public void setArtikelBezeichnung(String artikelBezeichnung)
	{
		this.artikelBezeichnung = artikelBezeichnung;
	}

	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}
	
	public String toString()
	{
		return artikelBezeichnung + " " + preis;
	}
}
