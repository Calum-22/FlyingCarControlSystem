package Graphics;
import javax.swing.JFrame;

public class GraphicsFrame extends JFrame {
    GraphicsFrame(){
        this.add(new TestPanel()); //most recently added component gets displayed when repaint is called
        this.setTitle("Flying Car Control System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
