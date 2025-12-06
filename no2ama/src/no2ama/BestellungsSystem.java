//package no2ama;
////import java.io.BufferedReader;
////import java.io.FileReader;
////import java.io.FileWriter;
////import java.io.IOException;
//import java.util.ArrayList;
//
//public class BestellungsSystem
//{
////	private ArrayList<Artikel> artikelListe;
////	private ArrayList<Bestellung> bestellungListe;
////	private ArrayList<Artikel> warenkorbListe;
//	
//	public BestellungsSystem()
//	{
//		artikelListe = new ArrayList<>();
//		bestellungListe = new ArrayList<>();
//		warenkorbListe = new ArrayList<>();
//		
//	}
//	
////	public ArrayList<Artikel> readArtikelFromFile(String filename)
////	{
////		artikelListe.clear();
////		try
////		{
////			BufferedReader reader = new BufferedReader(new FileReader(filename));
////			String line;
////			
////			while ((line = reader.readLine()) != null)
////			{
////				String[] parts = line.split(";");
////				int nummer = Integer.parseInt(parts[0].trim());
////				String bezeichnung = parts[1].trim();
////				String preisStr = parts[2].trim();
////				
////				preisStr = preisStr.replace("€", "").replace(",", ".").trim();
////				double preis = Double.parseDouble(preisStr);
////				
////				Artikel artikel = new Artikel(nummer, bezeichnung, preis);
////				
////				artikelListe.add(artikel);
////			}
////			reader.close();
////		}
////		catch (Exception e)
////		{
////			e.printStackTrace();
////		}
////		return artikelListe;
////	}
//	public ArrayList<Artikel> getArtikelListe()
//	{
//		return artikelListe;
//	}
//		
//	public ArrayList<Artikel> getWarenkorbListe()
//	{
//	return warenkorbListe;
//	}
//
//	public void addToWarenkorb(Artikel artikel)
//	{
//		warenkorbListe.add(artikel);
//	}
//		
//	public void removeFromWarenkorb(Artikel artikel)
//	{
//		warenkorbListe.remove(artikel);
//	}
//	
////	public void submitBestellung(String kundenname)
////	{
////		String path = "Bestellungen.txt";
////		 try
////		 {
////			 FileWriter shakespeare = new FileWriter(path, true);
////			 for (Artikel artikel:warenkorbListe)
////			 {
////					Bestellung bestellung = new Bestellung(kundenname, artikel);
////					bestellungListe.add(bestellung);
////					shakespeare.write(kundenname + ";" + artikel.getArtikelNummer() + ";" + artikel.getArtikelBezeichnung() + ";" + artikel.getPreis()+ "\n");
////			 }
////			 shakespeare.close();
////			 warenkorbListe.clear();
////		 }
////		 catch(IOException e)
////		 {
////			 e.printStackTrace();
////		 }
////	}
//}
