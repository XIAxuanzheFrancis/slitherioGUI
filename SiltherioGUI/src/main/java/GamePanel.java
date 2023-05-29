import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.activation.ActivationMonitor;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

  //Snake
  int length;//816 max
  int[] snakeX = new int[600];
  int[] snakeY = new int[500];
  String direction;
  boolean isStart = false;//Game Status
  //delay ms
  Timer timer = new Timer(100, this);

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
    setFocusable(true);//Get Focused Events
    addKeyListener(this);
    timer.start();
  }

  //Anything in the game is drawn by a brush
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); //clear
    this.setBackground(Color.BLACK);
    Data.header.paintIcon(this, g, 15, 11);
    g.fillRect(15, 75, 850, 600);

    //painting a snake
    if (direction.equals("R")) {
      Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("L")) {
      Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("U")) {
      Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("D")) {
      Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
    }

    for (int i = 1; i < length; i++) {
      Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
    }

    if (isStart == false) {
      g.setColor(Color.pink);
      g.setFont(new Font("Arial", Font.BOLD, 50));
      g.drawString("Press space to start the game", 100, 300);
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_SPACE) {
      isStart = !isStart;
      repaint();
    }
    if (keyCode == KeyEvent.VK_LEFT) {
      direction = "L";
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      direction = "R";
    } else if (keyCode == KeyEvent.VK_UP) {
      direction = "U";
    } else if (keyCode == KeyEvent.VK_DOWN) {
      direction = "D";
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (isStart) {
      for (int i = length - 1; i > 0; i--) {
        snakeX[i] = snakeX[i - 1];
        snakeY[i] = snakeY[i - 1];
      }

      //directionMoving
      if (direction.equals("R")) {
        snakeX[0] = snakeX[0] + 25;
        //Boundary judgment
        if (snakeX[0] > 850) {
          snakeX[0] = 25;
        }
      } else if (direction.equals("L")) {
        snakeX[0] = snakeX[0] - 25;
        if (snakeX[0] < 25) {
          snakeX[0] = 850;
        }
      } else if (direction.equals("U")) {
        snakeY[0] = snakeY[0] - 25;
        if (snakeY[0] < 75) {
          snakeY[0] = 650;
        }
      } else if (direction.equals("D")) {
        snakeY[0] = snakeY[0] + 25;
        if (snakeY[0] > 650) {
          snakeY[0] = 25;
        }
      }

      repaint();
    }
    timer.start();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}

