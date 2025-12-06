package no2ama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DateihandlerIO extends Dateihandler
{
	public DateihandlerIO(String filename, String filename2)
	{
		super();
		try
		{
			reader = new BufferedReader(new FileReader(filename));
			shakespeare = new BufferedWriter(new FileWriter(filename2));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}