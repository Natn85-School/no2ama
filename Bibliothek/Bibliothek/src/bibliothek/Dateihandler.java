package bibliothek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Dateihandler
{
	protected BufferedReader reader;
	protected BufferedWriter writer;
	protected ArrayList<Buch> buecherListe = new ArrayList<Buch>();
	private String zeile;
	private String titel;
	private String autor;
	private String genre;
	private double preis;
	private String isbn;
	
	 public ArrayList<Buch> readBuch(String filename)
	 {
		 try
		 {
			 reader.readLine();
			 while((zeile = reader.readLine()) != null)
			 {
				 String[] teile = zeile.split(";");
				 titel = teile[0];
				 autor = teile[1];
				 genre = teile[2];
				 preis = Double.parseDouble(teile[3].trim());
				 isbn = teile[4];
				 Buch buch = new Buch(titel, autor, genre, preis, isbn);
				 buecherListe.add(buch);
			 }
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 return buecherListe;
	 }
}
