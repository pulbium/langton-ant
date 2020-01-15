import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LangtonAntFrame extends JFrame {

	Ant[] ants = new Ant[1];
	JPanel graphicPanel = new JPanel() {
		private static final long serialVersionUID = 278470297026981101L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Window window = SwingUtilities.getWindowAncestor(graphicPanel);
			LangtonAntFrame frame = (LangtonAntFrame) window;
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			g2.setColor(Color.BLACK);
			for (int i = 0; i < 10000; i++)
				for (int j = 0; j < ants.length; j++) {
					ants[j].move();
		//			frame.setTitle("Number of steps: " + ants[0].steps);
					}
			for (int x = 0; x < 1024; x++)
				for (int y = 0; y < 768; y++) {
					if (ants[0].map[x][y])
						g2.drawRect(x, y, 1, 1);
				}
			frame.setTitle("Number of steps: " + ants[0].steps);
			repaint();
		}
	};

	public LangtonAntFrame() throws HeadlessException {
		setSize(1024, 804);
		setResizable(false);
		graphicPanel.setSize(1024, 768);
		add(graphicPanel);

		for (int i = 0; i < ants.length; i++)
			ants[i] = new Ant();
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LangtonAntFrame();
	}

}
