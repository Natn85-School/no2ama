package bibliothek;

public class Buch
{
	protected String titel;
	protected String autor;
	protected String genre;
	protected double preis;
	protected String isbn;
	
	public Buch(String titel, String autor, String genre, double preis, String isbn)
	{
		this.titel = titel;
		this.autor = autor;
		this.genre = genre;
		this.preis = preis;
		this.isbn = isbn;
	}

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		this.titel = titel;
	}

	public String getAutor()
	{
		return autor;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String toString()
	{
		return titel + " - " + autor + " - " + genre + " - " + preis;
	}
}
