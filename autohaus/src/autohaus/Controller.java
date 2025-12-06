package autohaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller
{
	private AutoGui gui;
	private DateihandlerIO handler = new DateihandlerIO("AutoListe.txt", "Bestellung.txt");
	private ArrayList<Auto> autoArray = new ArrayList<Auto>();
	private ArrayList<Auto> afterModell = new ArrayList<>();
	private ArrayList<Auto> afterFarbe = new ArrayList<Auto>();
	private ArrayList<Auto> afterPs = new ArrayList<Auto>();
	private ArrayList<Extras> extrasListe = new ArrayList<Extras>();
	protected ArrayList<Auswahl> auswahlListe = new ArrayList<Auswahl>();
	
	private String modell;
	private String farbe;
	private Integer ps;
	private double preis;
	private double extraPreis;
	private double nettoPreis;
	private double bruttoPreis;
	
	
	public Controller(AutoGui gui)
	{
		this.gui = gui;
		this.handler = handler;
		this.autoArray = autoArray;
		
		gui.getComboBoxModell().addActionListener(e -> 
		{
			modell = (String) gui.getComboBoxModell().getSelectedItem();
			if(modell != null)
			{
				getAutosByModell(modell);
			}
		});
		gui.getComboBoxFarbe().addActionListener(e -> 
		{
			farbe = (String) gui.getComboBoxFarbe().getSelectedItem();
			if(farbe != null)
			{
				getAutosByModellAndFarbe(farbe);
			}
		});
		gui.getComboBoxPs().addActionListener(e -> 
		{
			ps = (Integer) gui.getComboBoxPs().getSelectedItem();
			if( ps != null)
			{
			getPreisByPS(ps);

			getExtras();
			}
		});
		gui.getComboBoxExtras().addActionListener(e -> 
		{
			rechnen(preis, extraPreis);
		});
		
		initialize();
	}

	
	public void initialize()
	{
		autoArray = handler.readFromTxt("AutoListe.txt");
		for (Auto auto : autoArray)
		{
			gui.getComboBoxModell().addItem(auto.getModell());
		}
		
		//getExtras();
	}
	
	public void getAutosByModell(String modell)
	{
		gui.getComboBoxFarbe().removeAllItems();
		afterModell.clear();
		for(Auto auto : autoArray)
		{
			if (auto.getModell().equalsIgnoreCase(modell))
			{
				afterModell.add(auto);
				gui.getComboBoxFarbe().addItem(auto.getFarbe());
			}
		}
	}
	
	public void getAutosByModellAndFarbe(String farbe)
	{
		//gui.getComboBoxPs().removeAllItems();
		afterFarbe.clear();
		for (Auto auto : afterModell)
		{
			if(auto.getFarbe().equalsIgnoreCase(farbe))
			{
				afterFarbe.add(auto);
				gui.getComboBoxPs().addItem(auto.getPs());
			}
		}
	}
	
	public double getPreisByPS(Integer ps)
	{
		ps = (int) gui.getComboBoxPs().getSelectedItem();
		afterPs.clear();
		for (Auto auto : afterFarbe)
		{
			if(auto.getPs() == ps)
			{
				afterPs.add(auto);
				preis = auto.getPreis();
			}
		}
		return preis;
	}
	
	public void getExtras()
	{
		extrasListe.clear();
		if(extrasListe.isEmpty())
		{
			Extras extra = new Extras("-", 0);
			extrasListe.add(extra);
			extra = new Extras("Navigationsgerät", 300);
			extrasListe.add(extra);
			extra = new Extras("Bose_Soundsystem", 1300);
			extrasListe.add(extra);
			for (Extras e : extrasListe)
			{
				gui.getComboBoxExtras().addItem(e.getName());
			}
		}
	}
	
	public void rechnen(double preis, double extraPreis)
	{
		int i = gui.getComboBoxExtras().getSelectedIndex();
		if (i > -1)
		{
			extraPreis = extrasListe.get(i).getPreis();
			System.out.println("lfjow" + extraPreis);
		}
		preis = getPreisByPS(ps);
		nettoPreis = preis + extraPreis;
		bruttoPreis = nettoPreis * 1.19;
		System.out.println(nettoPreis);
	}
	
	public void auswahlBest()
	{
		String extraName = gui.getComboBoxExtras().getSelectedItem().toString();
		Auswahl auswahl = new Auswahl(modell, farbe, (int) ps, extraName, bruttoPreis);
		auswahlListe.add(auswahl);
		gui.setList(auswahlListe);
	}
	
//ewsssssssstgfcv 
}
