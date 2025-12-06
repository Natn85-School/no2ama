package autohaus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Dateihandler
{
	protected BufferedReader reader;
	protected BufferedWriter writer;
	
	
	ArrayList<Auto> autoArray = new ArrayList<Auto>();
	String zeile;
	
	public ArrayList<Auto> readFromTxt(String filename)
	{
		try
		{
			reader.readLine(); //reads first line but does nothing with it
			while((zeile = reader.readLine()) != null) //starts with the second line, which are the ones needed
			{
				String[] teile = zeile.split(";");
				String modell = teile[0].trim();
				String farbe = teile[1].trim();
				int ps = Integer.parseInt(teile[2].trim());
				double preis = Double.parseDouble(teile[3].trim().replace(".", ""));
				System.out.println(teile[3]);
				autoArray.add(new Auto(modell, farbe, ps, preis));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return autoArray;
	}
}