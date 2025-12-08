package autohaus;

public class Auto
{
		private String modell;
		private String farbe;
		private int ps;
		private double preis;
		
		public Auto(String modell, String farbe, int ps, double preis)
		{
			this.modell = modell;
			this.farbe = farbe;
			this.ps = ps;
			this.preis = preis;
		}

		public String getModell()
		{
			return modell;
		}

		public void setModell(String modell)
		{
			this.modell = modell;
		}

		public String getFarbe()
		{
			return farbe;
		}

		public void setFarbe(String farbe)
		{
			this.farbe = farbe;
		}

		public int getPs()
		{
			return ps;
		}

		public void setPs(int ps)
		{
			this.ps = ps;
		}

		public double getPreis()
		{
			return preis;
		}

		public void setPreis(double preis)
		{
			this.preis = preis;
		}	
}
