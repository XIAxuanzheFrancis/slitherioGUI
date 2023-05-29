import java.net.URL;
import javax.swing.ImageIcon;

//Data Center
public class Data {
  private static URL headerURL = Data.class.getResource("IMG/header.png");
  private static URL bodyURL = Data.class.getResource("IMG/body.png");
  private static URL downURL = Data.class.getResource("IMG/down.png");
  private static URL foodURL = Data.class.getResource("IMG/food.png");
  private static URL leftURL = Data.class.getResource("IMG/left.png");
  private static URL rightURL = Data.class.getResource("IMG/right.png");
  private static URL upURL = Data.class.getResource("IMG/up.png");
  public static ImageIcon header = new ImageIcon(headerURL);
  public static ImageIcon body = new ImageIcon(bodyURL);
  public static ImageIcon down = new ImageIcon(downURL);
  public static ImageIcon food = new ImageIcon(foodURL);
  public static ImageIcon left = new ImageIcon(leftURL);
  public static ImageIcon right = new ImageIcon(rightURL);
  public static ImageIcon up = new ImageIcon(upURL);

}
