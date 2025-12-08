package bibliothek;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BibGui {

	public JFrame frame;
	private JButton btnBestellen;
	private JComboBox comboBoxGeschenk;
	private JLabel lblGeschenkverpackung;
	private JLabel lblVersandart;
	private JComboBox comboBoxVersand;
	private JTextField textFieldAnzahl;
	private JLabel lblAnzahl;
	private JLabel lblNewLabel;
	private JComboBox comboBoxBuch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibGui window = new BibGui();
					Controller controller = new Controller(window);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BibGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnBestellen());
		frame.getContentPane().add(getComboBoxGeschenk());
		frame.getContentPane().add(getLblGeschenkverpackung());
		frame.getContentPane().add(getLblVersandart());
		frame.getContentPane().add(getComboBoxVersand());
		frame.getContentPane().add(getTextFieldAnzahl());
		frame.getContentPane().add(getLblAnzahl());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getComboBoxBuch());
	}

	public JButton getBtnBestellen() {
		if (btnBestellen == null) {
			btnBestellen = new JButton("Buch Bestellen");
			btnBestellen.setBounds(93, 377, 285, 23);
		}
		return btnBestellen;
	}
	public JComboBox getComboBoxGeschenk() {
		if (comboBoxGeschenk == null) {
			comboBoxGeschenk = new JComboBox();
			comboBoxGeschenk.setBounds(184, 245, 194, 22);
		}
		return comboBoxGeschenk;
	}
	private JLabel getLblGeschenkverpackung() {
		if (lblGeschenkverpackung == null) {
			lblGeschenkverpackung = new JLabel("Geschenkverpackung");
			lblGeschenkverpackung.setBounds(76, 249, 109, 14);
		}
		return lblGeschenkverpackung;
	}
	private JLabel getLblVersandart() {
		if (lblVersandart == null) {
			lblVersandart = new JLabel("Versandart");
			lblVersandart.setBounds(76, 188, 68, 14);
		}
		return lblVersandart;
	}
	public JComboBox getComboBoxVersand() {
		if (comboBoxVersand == null) {
			comboBoxVersand = new JComboBox();
			comboBoxVersand.setBounds(184, 184, 194, 22);
		}
		return comboBoxVersand;
	}
	public JTextField getTextFieldAnzahl() {
		if (textFieldAnzahl == null) {
			textFieldAnzahl = new JTextField();
			textFieldAnzahl.setColumns(10);
			textFieldAnzahl.setBounds(184, 124, 194, 20);
		}
		return textFieldAnzahl;
	}
	private JLabel getLblAnzahl() {
		if (lblAnzahl == null) {
			lblAnzahl = new JLabel("Anzahl");
			lblAnzahl.setBounds(76, 127, 46, 14);
		}
		return lblAnzahl;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Buch");
			lblNewLabel.setBounds(76, 58, 46, 14);
		}
		return lblNewLabel;
	}
	public JComboBox getComboBoxBuch() {
		if (comboBoxBuch == null) {
			comboBoxBuch = new JComboBox();
			comboBoxBuch.setBounds(184, 54, 194, 22);
		}
		return comboBoxBuch;
	}
}
