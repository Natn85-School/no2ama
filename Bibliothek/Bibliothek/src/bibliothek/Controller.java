package bibliothek;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.text.View;

public class Controller
{
	private BibGui gui;
	private DateihandlerIO handler = new DateihandlerIO("Buecher.txt", "Bestellungen.txt");
//	private DefaultComboBoxModel<Buch> buchModel = new DefaultComboBoxModel<Buch>();
	private ArrayList<Buch> buecherArray = new ArrayList<Buch>();
	
	private double versandS = 5;
	private double versandE = 10;
	private double geschenkJ = 2.5;
	private double gesamtPreis = 0;
	
	
	public Controller(BibGui gui)
	{
		this.gui = gui;
//		this.buchModel = buchModel;
		
		gui.getBtnBestellen().addActionListener(e -> bestellen());
		
		initialize();
	}
	
	public void initialize()
	{
		gui.getComboBoxBuch().removeAllItems();
		gui.getTextFieldAnzahl().setText("0");
//		gui.getComboBoxVersand().removeAllItems();
//		gui.getComboBoxGeschenk().removeAllItems();
		
		readBuch();
		gui.getComboBoxVersand().addItem("Standard - 5€");
		gui.getComboBoxVersand().addItem("Express - 10€");
		gui.getComboBoxGeschenk().addItem("nein");
		gui.getComboBoxGeschenk().addItem("ja");
	}
	
	public void readBuch()
	{
		buecherArray = handler.readBuch("Buecher.txt");
		for (Buch buch : buecherArray)
		{
			gui.getComboBoxBuch().addItem(buch);
		}
	}
	
	public void rechnen()
	{
		double anzahl = Double.parseDouble(gui.getTextFieldAnzahl().getText());
		Buch buch = (Buch) gui.getComboBoxBuch().getSelectedItem();
		int selectedV = gui.getComboBoxVersand().getSelectedIndex();
		int selectedG = gui.getComboBoxGeschenk().getSelectedIndex();
		
		gesamtPreis = (gesamtPreis  + buch.getPreis()) * anzahl;
		
		if(gesamtPreis > 0)
		{
			if (selectedV == 1)
			{
				gesamtPreis = gesamtPreis + versandE;
			}
			else
			{
				gesamtPreis = gesamtPreis + versandS;
			}
			
			if (selectedG == 1)
			{
				gesamtPreis = gesamtPreis + geschenkJ;
			}
		}
	}
	
	public void bestellen()
	{
		rechnen();
		javax.swing.JOptionPane.showMessageDialog(null, String.format("Bestellung wurde gespeichert! %.2f", gesamtPreis), "Bestellung",javax.swing.JOptionPane.INFORMATION_MESSAGE);
	}
}
