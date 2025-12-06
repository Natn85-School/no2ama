package no2ama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;


public abstract class Dateihandler
{
	protected BufferedReader reader;
	protected BufferedWriter shakespeare;
	
	DefaultListModel<Artikel> artikelModel = new DefaultListModel<Artikel>();
	DefaultListModel<Artikel> warenkorbModel = new DefaultListModel<Artikel>();
	ArrayList<Bestellung> bestellungListe = new ArrayList<Bestellung>();
	String zeile;
	
	
	public DefaultListModel<Artikel> readArtikelFromFile()
	{
		try
		{
			while((zeile = reader.readLine()) != null)
			{
				String[] teile = zeile.split(";");
				int nummer = Integer.parseInt(teile[0].trim());
				String bezeichnung = teile[1].trim();
				String preisStr = teile[2].trim();
				
				preisStr = preisStr.replace("€", "").replace(",", ".").trim();
				double preis = Double.parseDouble(preisStr);
			
				artikelModel.addElement(new Artikel(nummer, bezeichnung, preis));
				System.out.println(artikelModel.getSize());
			}
			System.out.println(artikelModel.getSize());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return artikelModel;
	}
	
	public void submitBestellung(String kundenname, DefaultListModel<Artikel> warenkorb, String filename2)
	{
		 Bestellung bestellung = null;
		 try
		 {
			 FileWriter shakespeare = new FileWriter(filename2, true);
			 for (int i = 0; i < warenkorb.getSize(); i++)
			 {
				 Artikel artikel = warenkorb.getElementAt(i);
				 bestellung = new Bestellung(kundenname, artikel);
				 bestellungListe.add(bestellung);
				 shakespeare.write(kundenname + ";" + artikel.getArtikelNummer() + ";" + artikel.getArtikelBezeichnung() + ";" + artikel.getPreis()+ "\n");
			 }
			 shakespeare.close();
			 warenkorb.clear();
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
	}
}