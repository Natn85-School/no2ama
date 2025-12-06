package no2ama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class No2ama
{

	private JFrame frame;
	private JList artikelList;
	private JList warenkorbList;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField knameText;
	private JButton btnWarenkorb;
	private JButton btnArtikel;
	private JButton btnBestellungAbschicken;


	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					No2ama window = new No2ama();
					Controller controller = new Controller(window);
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public No2ama()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getArtikelList());
		frame.getContentPane().add(getWarenkorbList());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getKnameText());
		frame.getContentPane().add(getBtnWarenkorb());
		frame.getContentPane().add(getBtnArtikel());
		frame.getContentPane().add(getBtnBestellungAbschicken());
	}
	
	public JList getArtikelList() {
		if (artikelList == null) {
			artikelList = new JList();
			artikelList.setBounds(10, 96, 224, 193);
		}
		return artikelList;
	}
	public JList getWarenkorbList() {
		if (warenkorbList == null) {
			warenkorbList = new JList();
			warenkorbList.setBounds(393, 96, 224, 193);
		}
		return warenkorbList;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Warenkorb");
			lblNewLabel.setBounds(393, 71, 60, 14);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Kundenname:");
			lblNewLabel_1.setBounds(63, 300, 75, 14);
		}
		return lblNewLabel_1;
	}
	public JTextField getKnameText() {
		if (knameText == null) {
			knameText = new JTextField();
			knameText.setBounds(148, 297, 126, 20);
			knameText.setColumns(10);
		}
		return knameText;
	}
	public JButton getBtnWarenkorb() {
		if (btnWarenkorb == null) {
			btnWarenkorb = new JButton(">");
			btnWarenkorb.setBounds(262, 113, 89, 41);
		}
		return btnWarenkorb;
	}
	public JButton getBtnArtikel() {
		if (btnArtikel == null) {
			btnArtikel = new JButton("<");
			btnArtikel.setBounds(262, 177, 89, 41);
		}
		return btnArtikel;
	}
	public JButton getBtnBestellungAbschicken() {
		if (btnBestellungAbschicken == null) {
			btnBestellungAbschicken = new JButton("Bestellung abschicken");
			btnBestellungAbschicken.setBounds(393, 297, 160, 20);
		}
		return btnBestellungAbschicken;
	}
	public JFrame getFrame()
	{
		return frame;
	}
}
