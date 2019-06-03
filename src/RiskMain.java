import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RiskMain extends JPanel {
    public static int width = 1600, height = 900;

    public RiskMain(int width, int height) {
        setSize(width, height);
        setupMouseListener();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillRect(50,50,500,500);
    }

    public void setupMouseListener(){
        addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("RISK");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1600, 900); //(x, y, w, h) 22 due to title bar.

        RiskMain panel = new RiskMain(WIDTH, HEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}