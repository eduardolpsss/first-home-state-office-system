//Eduardo Luiz Pontes de Souza - UC19100270
package projeto_mpc.mpc.Background_image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon image = new ImageIcon(getClass().getResource("Logo.png"));
	JLabel label = new JLabel(image);

	public Image() {

		add(label);

		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setVisible(true);
	}
}