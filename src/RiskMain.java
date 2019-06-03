import javax.swing.*;
import java.awt.*;

public class RiskMain extends JPanel {
    private static int WIDTH, HEIGHT;
    private RiskMenu menuPanel;

    public RiskMain(){

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.fillRect(50,50,200,200);
        menuPanel.draw(g2);
    }

    public static void main(String[] args) {
        WIDTH = 1600;
        HEIGHT = 900;

        JFrame frame = new JFrame("Risk");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel menuPanel = new RiskMenu(WIDTH, HEIGHT);



        frame.setSize(WIDTH, HEIGHT+24);
        frame.setVisible(true);

        frame.add(menuPanel);
        menuPanel.setFocusable(true);
        menuPanel.grabFocus();

    }
}
