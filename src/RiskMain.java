import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class RiskMain extends JPanel {
    public static int WIDTH = 1440, HEIGHT = 900;
    private BufferedImage worldMapBackground;
    private boolean startMenu;
    private JButton startButton;

    public RiskMain(int width, int height) {
        setSize(width, height);
        setupImages();
        setupMouseListener();

        startMenu = true;
        setLayout(null);
        JButton startButton = new JButton("Start Game");
        add(startButton);
        startButton.setBounds(width/2-50, height/2-25, 100 ,50);
        startButton.addActionListener( e -> start() );


    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(worldMapBackground, 0, 0, null);

        if (startMenu) {

        }
    }

    public void start(){
        System.out.println("HI");
        remove(startButton);

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



    public void setupImages() {
        try{
            worldMapBackground = ImageIO.read(new File("res/worldMapBackground.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("RISK");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, WIDTH, HEIGHT); //(x, y, w, h) 22 due to title bar.

        RiskMain panel = new RiskMain(WIDTH, HEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);

    }
}