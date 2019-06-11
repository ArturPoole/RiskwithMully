import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class RiskMain extends JPanel {
    public static int WIDTH = 1440, HEIGHT = 900;
    private BufferedImage worldMapBackground, riskMap, bottomBar;
    private boolean startMenu, setUp;
    private JButton startButton;
    private Player[] players;
    private Country[] countries;
    private Color[] playerColors;

    public RiskMain(int width, int height) {
        setSize(width, height);
        setupImages();
        setupMouseListener();

        startMenu = true;
        setLayout(null);
        startButton = new JButton("");
        startButton.setBounds(width/2-50, height/2-25, 100 ,50);
        startButton.addActionListener( e -> start() );
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        add(startButton);                                       // START BUTTON

        countries = new Country[25];                            // ALL COUNTRIES
        setupCountries();

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (startMenu) {
            g2.drawImage(worldMapBackground, 0, 0, null);
            g2.setColor(new Color(40, 40, 40, 240));
            g2.fillRect(WIDTH/2-50, HEIGHT/2-25, 100 ,50);
            g2.setColor(Color.RED);
            g2.drawRect(WIDTH/2-50, HEIGHT/2-25, 100 ,50);
            g2.drawString("START GAME", WIDTH/2-40, HEIGHT/2);

        }

        if (setUp) {
            g2.drawImage(riskMap,0, 0, null );
            g2.drawImage(bottomBar, 0, 700, null);

            countries[0].draw(g2);
            countries[1].draw(g2);

//            Color gray = new Color(40, 40, 40);
//            g2.setColor(gray);
//            g2.fillRect();
        }


    }

    public void start(){
        System.out.println("HI");
        remove(startButton);
        revalidate();
        repaint();
        startMenu = false;
        setUp = true;
    }

    public void addPlayer() {
        playerColors = new Color[6];
        playerColors[0] = new Color(255, 0, 0);
        playerColors[1] = new Color(0, 0, 255);
        playerColors[2] = new Color(0, 255, 0);
        playerColors[3] = new Color(222, 255, 0);
        playerColors[4] = new Color(0, 0 , 0);
        playerColors[5] = new Color(252, 0, 255);



    }

    public void setupCountries() {
        ArrayList<Point> cords = new ArrayList<>();

        cords.add(new Point(98, 383));
        cords.add(new Point(168, 406));
        cords.add(new Point(79, 524));
        cords.add(new Point(115, 568));
        cords.add(new Point(267, 563));
        cords.add(new Point(348, 502));
        cords.add(new Point(422, 456));
        cords.add(new Point(138, 360));
        countries[0] = new Country("Spain", cords); // Spain

        cords = new ArrayList<>();

        cords.add(new Point(73, 521));
        cords.add(new Point(159, 404));
        cords.add(new Point(90, 387));
        cords.add(new Point(14, 521));
        countries[1] = new Country("Portugal", cords); // Spain







    }
    public void setupMouseListener(){
        addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {
                if (countries[0].isClicked(new Point(e.getX(), e.getY())))
                    System.out.println("YEET");

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

        try{
            riskMap = ImageIO.read(new File("res/RiskMap1.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            bottomBar = ImageIO.read(new File("res/bottomBar.jpg"));
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