import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  //Anything in the game is drawn by a brush
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); //clear
    this.setBackground(Color.BLACK);
    Data.header.paintIcon(this,g,20,10);
    g.fillRect(25,75,850,600);
  }
}
