import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class StartGame {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setBounds(10,10,900,700);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
