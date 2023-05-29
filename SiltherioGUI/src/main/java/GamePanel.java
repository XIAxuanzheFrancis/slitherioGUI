import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  //Snake
  int length;//816 max
  int[] snakeX = new int[600];
  int[] snakeY = new int[500];
  String direction;

  public void init() {
    length = 3;
    snakeX[0] = 100;
    snakeY[0] = 100;//head of snake
    snakeX[1] = 75;
    snakeY[1] = 100;
    snakeX[2] = 50;
    snakeY[2] = 100;
    direction = "R";
  }

  public GamePanel() {
    init();
  }

  //Anything in the game is drawn by a brush
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); //clear
    this.setBackground(Color.BLACK);
    Data.header.paintIcon(this, g, 15, 11);
    g.fillRect(15, 75, 850, 600);

    //painting a snake
    if(direction.equals("R")){
      Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
    }
    else if(direction.equals("L")){
      Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
    }
    else if(direction.equals("U")){
      Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
    }
    else if(direction.equals("D")){
      Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
    }

    for (int i = 1; i < length; i++) {
      Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
    }



  }
}
