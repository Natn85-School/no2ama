package autohaus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class AutoGui
{

	private JFrame frame;
	private JLabel lblNewLabel;
	private JList list;
	private JLabel lblModell;
	private JLabel lblFarbe;
	private JLabel lblPs;
	private JLabel lblExtra;
	private JLabel lblNetto;
	private JLabel lblMwst;
	private JLabel lblBrutto;
	private JLabel lblNewLabel_1_7;
	private JLabel lblNewLabel_1_8;
	private JLabel lblNewLabel_1_9;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AutoGui window = new AutoGui();
					Controller contoller =  new Controller(window);
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getList());
		frame.getContentPane().add(getLblModell());
		frame.getContentPane().add(getLblFarbe());
		frame.getContentPane().add(getLblPs());
		frame.getContentPane().add(getLblExtra());
		frame.getContentPane().add(getLblNetto());
		frame.getContentPane().add(getLblMwst());
		frame.getContentPane().add(getLblBrutto());
		frame.getContentPane().add(getLblGesamtPreis());
		frame.getContentPane().add(getLblBruttoPreis());
		frame.getContentPane().add(getLblMwstPreis());
		frame.getContentPane().add(getBtnAuswahlBest());
		frame.getContentPane().add(getBtnAutoBestellen());
		frame.getContentPane().add(getComboBoxModell());
		frame.getContentPane().add(getComboBoxFarbe());
		frame.getContentPane().add(getComboBoxPs());
		frame.getContentPane().add(getComboBoxExtras());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ihre Auswahl:");
			lblNewLabel.setFont(new Font("Bodoni MT Black", Font.PLAIN, 16));
			lblNewLabel.setBounds(335, 33, 158, 21);
		}
		return lblNewLabel;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(335, 65, 262, 137);
		}
		return list;
	}
	private JLabel getLblModell() {
		if (lblModell == null) {
			lblModell = new JLabel("Modell:");
			lblModell.setBounds(26, 95, 76, 21);
		}
		return lblModell;
	}
	private JLabel getLblFarbe() {
		if (lblFarbe == null) {
			lblFarbe = new JLabel("Farbe:");
			lblFarbe.setBounds(26, 160, 76, 21);
		}
		return lblFarbe;
	}
	private JLabel getLblPs() {
		if (lblPs == null) {
			lblPs = new JLabel("PS:");
			lblPs.setBounds(26, 228, 76, 21);
		}
		return lblPs;
	}
	private JLabel getLblExtra() {
		if (lblExtra == null) {
			lblExtra = new JLabel("Extras");
			lblExtra.setBounds(26, 284, 76, 21);
		}
		return lblExtra;
	}
	private JLabel getLblNetto() {
		if (lblNetto == null) {
			lblNetto = new JLabel("Gesamtpreis netto:");
			lblNetto.setBounds(335, 231, 97, 21);
		}
		return lblNetto;
	}
	private JLabel getLblMwst() {
		if (lblMwst == null) {
			lblMwst = new JLabel("19% MWSt:");
			lblMwst.setBounds(335, 273, 76, 21);
		}
		return lblMwst;
	}
	private JLabel getLblBrutto() {
		if (lblBrutto == null) {
			lblBrutto = new JLabel("Bruttopreis:");
			lblBrutto.setBounds(335, 317, 76, 21);
		}
		return lblBrutto;
	}
	public JLabel getLblGesamtPreis() {
		if (lblNewLabel_1_7 == null) {
			lblNewLabel_1_7 = new JLabel("-");
			lblNewLabel_1_7.setBounds(476, 231, 76, 21);
		}
		return lblNewLabel_1_7;
	}
	public JLabel getLblMwstPreis() {
		if (lblNewLabel_1_8 == null) {
			lblNewLabel_1_8 = new JLabel("-");
			lblNewLabel_1_8.setBounds(476, 276, 76, 21);
		}
		return lblNewLabel_1_8;
	}
	public JLabel getLblBruttoPreis() {
		if (lblNewLabel_1_9 == null) {
			lblNewLabel_1_9 = new JLabel("-");
			lblNewLabel_1_9.setBounds(476, 320, 76, 21);
		}
		return lblNewLabel_1_9;
	}
	public JButton getBtnAuswahlBest() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Auswahl bestätigen");
			btnNewButton.setBounds(67, 357, 158, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnAutoBestellen() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Auto Bestellen");
			btnNewButton_1.setBounds(356, 357, 158, 23);
		}
		return btnNewButton_1;
	}
	public JComboBox getComboBoxModell() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(112, 94, 173, 22);
		}
		return comboBox;
	}
	public JComboBox getComboBoxFarbe() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(112, 159, 173, 22);
		}
		return comboBox_1;
	}
	public JComboBox getComboBoxPs() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setBounds(112, 227, 173, 22);
		}
		return comboBox_2;
	}
	public JComboBox getComboBoxExtras() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setBounds(112, 283, 173, 22);
		}
		return comboBox_3;
	}
}
