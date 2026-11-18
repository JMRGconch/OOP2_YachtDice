import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private CardLayout cardLayout;
	private JPanel cards;
	
	public void showWindow(String name) {
		cardLayout.show(cards, name);
	}
}
