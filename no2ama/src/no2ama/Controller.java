package no2ama;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.DefaultListModel;

import java.awt.event.ActionEvent;

public class Controller implements ActionListener
{
	private No2ama view;
	private DefaultListModel<Artikel> artikelModel = new DefaultListModel<Artikel>();
	private DefaultListModel<Artikel> warenkorbModel = new DefaultListModel<Artikel>();
	private DateihandlerIO handler = new DateihandlerIO("Artikeln.txt", "Bestellungen.txt");
	
	public Controller(No2ama view)
	{
		this.view = view;
		artikelModel = new DefaultListModel<Artikel>();
		
		view.getBtnWarenkorb().addActionListener(this);
		view.getBtnArtikel().addActionListener(this);
		view.getBtnBestellungAbschicken().addActionListener(this);
		
		initialize();
		updateWarenkorbListe();
		updateArtikelListe();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == view.getBtnWarenkorb())
		{
			addToWarenkorb();
		}
		else if (e.getSource() == view.getBtnArtikel())
		{
			removeFromWarenkorb();
		} 
		else if (e.getSource() == view.getBtnBestellungAbschicken())
		{
			saveOrders();
		}
	}
	
	private void addToWarenkorb()
	{
		int selectedIndex = view.getArtikelList().getSelectedIndex();
		
		if(selectedIndex == -1) return;
		
		Artikel selected = artikelModel.get(selectedIndex);
		
		artikelModel.removeElement(selected);
		warenkorbModel.addElement(selected);
		
		updateArtikelListe();
		updateWarenkorbListe();
	}
	
	private void removeFromWarenkorb()
	{
		int selectedIndex = view.getWarenkorbList().getSelectedIndex();
		
		if(selectedIndex == -1) return;
		
		Artikel selected = warenkorbModel.get(selectedIndex);
		
		artikelModel.addElement(selected);
		warenkorbModel.removeElement(selected);
		
		updateArtikelListe();
		updateWarenkorbListe();
	}
	
	private void saveOrders()
	{
		String kundenname = view.getKnameText().getText();
		
		if (kundenname.isEmpty()) return;
		
		handler.submitBestellung(kundenname, warenkorbModel, "Bestellungen.txt");
		view.getKnameText().setText("");
		
		javax.swing.JOptionPane.showMessageDialog(view.getFrame(), "Bestellung wurde gespeichert!", "Bestellung",javax.swing.JOptionPane.INFORMATION_MESSAGE);

		handler.readArtikelFromFile();
		initialize();
	}
	
	private void initialize()
	{
		System.out.println("Initialize aufgerufen");
		handler = new DateihandlerIO("Artikeln.txt", "Bestellungen.txt");
		artikelModel = handler.readArtikelFromFile();
		view.getArtikelList().setModel(artikelModel);
		view.getWarenkorbList().setModel(warenkorbModel);
	}
	
	private void updateWarenkorbListe()
	{
		view.getWarenkorbList().setModel(warenkorbModel);
	}
	
	private void updateArtikelListe()
	{
		view.getArtikelList().setModel(artikelModel);
	}
}
