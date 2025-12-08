package autohaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

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
	private DefaultListModel<Auswahl> auswahlModel = new DefaultListModel<Auswahl>();
	
	private String modell;
	private String farbe;
	private Integer ps;
	private double preis;
	private double auswahlPreis = 0;
	private double extraPreis = 0;
	private double nettoPreis = 0;
	private double gesamtNetto = 0;
	private double mwst = 0;
	private double bruttoPreis = 0;
	private Auswahl auswahl;
	
	
	public Controller(AutoGui gui)
	{
		this.gui = gui;
		this.handler = handler;
		this.autoArray = autoArray;
		this.auswahlModel = auswahlModel;
		
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
		gui.getBtnAuswahlBest().addActionListener(e -> 
		{
			rechnen(auswahlPreis, extraPreis);
			auswahlBest();
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
		
		gui.getLblBruttoPreis().setText(Double.toString(bruttoPreis));
		gui.getLblMwstPreis().setText(Double.toString(mwst));
		gui.getLblGesamtPreis().setText(Double.toString(gesamtNetto));
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
		nettoPreis = 0;
		extraPreis = 0;
		int i = gui.getComboBoxExtras().getSelectedIndex();
		if (i > -1)
		{
			extraPreis = extrasListe.get(i).getPreis();
			System.out.println("extra: " + extraPreis);
		}
		
		if (auswahl != null)
		{
			preis = getPreisByPS(ps);
		}
		nettoPreis = preis + extraPreis;
		gesamtNetto = gesamtNetto + nettoPreis;
		mwst = gesamtNetto * 0.19;
		bruttoPreis = gesamtNetto + mwst;
		System.out.println("preis: " + preis);
	}
	
	public void auswahlBest()
	{
		rechnen(preis, extraPreis);
		
		String extraName = gui.getComboBoxExtras().getSelectedItem().toString();
		System.out.println(modell + farbe + (int) ps + extraName + nettoPreis);
		auswahl = new Auswahl(modell, farbe, (int) ps, extraName, nettoPreis);
		System.out.println("Auswahl: " + auswahl);
		auswahlModel.addElement(auswahl);
		gui.getList().setModel(auswahlModel);
		initialize();
	}
	
//ewsssssssstgfcv 
}
