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
            for (Country c: countries) {
                if (c != null)
                    c.draw(g2);
            }


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

        ArrayList<Point> cords = new ArrayList<>();                  // Spain
        cords.add(new Point(98, 383));
        cords.add(new Point(168, 406));
        cords.add(new Point(79, 524));
        cords.add(new Point(110, 605));
        cords.add(new Point(205, 615));
        cords.add(new Point(348, 502));
        cords.add(new Point(422, 456));
        cords.add(new Point(138, 360));
        countries[0] = new Country("Spain", cords);

        cords = new ArrayList<>();                                  // Portugal
        cords.add(new Point(73, 521));
        cords.add(new Point(159, 404));
        cords.add(new Point(90, 387));
        cords.add(new Point(14, 521));
        countries[1] = new Country("Portugal", cords);

        cords = new ArrayList<>();                                  // Morocco
        cords.add(new Point(0, 621));
        cords.add(new Point(83, 594));
        cords.add(new Point(132, 613));
        cords.add(new Point(209, 622));
        cords.add(new Point(209, 675));
        cords.add(new Point(149, 692));
        cords.add(new Point(0, 692));
        countries[2] = new Country("Morocco", cords);

        cords = new ArrayList<>();                                  // Algeria
        cords.add(new Point(214, 616));
        cords.add(new Point(538, 616));
        cords.add(new Point(486, 692));
        cords.add(new Point(214, 692));
        countries[3] = new Country("Algeria", cords);

        cords = new ArrayList<>();                                  // Tunisia
        cords.add(new Point(509, 692));
        cords.add(new Point(602, 692));
        cords.add(new Point(632, 625));
        cords.add(new Point(546, 625));
        countries[4] = new Country("Tunisia", cords);

        cords = new ArrayList<>();                                  // France
        cords.add(new Point(426, 445));
        cords.add(new Point(549, 440));
        cords.add(new Point(549, 304));
        cords.add(new Point(482, 233));
        cords.add(new Point(361, 259));
        cords.add(new Point(298, 283));
        cords.add(new Point(305, 412));
        countries[5] = new Country("France", cords);

        cords = new ArrayList<>();                                  // Belgium
        cords.add(new Point(546, 281));
        cords.add(new Point(488, 238));
        cords.add(new Point(517, 231));
        cords.add(new Point(563, 255));
        countries[6] = new Country("Belgium", cords);

        cords = new ArrayList<>();                                  // Netherlands
        cords.add(new Point(605, 195));
        cords.add(new Point(556, 180));
        cords.add(new Point(524, 227));
        cords.add(new Point(569, 251));
        countries[7] = new Country("Netherlands", cords);

        cords = new ArrayList<>();                                  // United Kingdom
        cords.add(new Point(457, 224));
        cords.add(new Point(279, 217));
        cords.add(new Point(379, 14));
        cords.add(new Point(454, 21));
        countries[8] = new Country("United Kingdom", cords);

        cords = new ArrayList<>();                                  // Ireland
        cords.add(new Point(241, 79));
        cords.add(new Point(335, 86));
        cords.add(new Point(289, 164));
        cords.add(new Point(187, 151));
        countries[9] = new Country("Ireland", cords);

        cords = new ArrayList<>();                                  // Germany
        cords.add(new Point(713, 344));
        cords.add(new Point(572, 347));
        cords.add(new Point(587, 240));
        cords.add(new Point(610, 190));
        cords.add(new Point(654, 148));
        cords.add(new Point(933, 162));
        cords.add(new Point(970, 210));
        cords.add(new Point(852, 241));
        cords.add(new Point(874, 297));
        cords.add(new Point(769, 268));
        cords.add(new Point(710, 283));
        countries[10] = new Country("Germany", cords);

        cords = new ArrayList<>();                                  // Russia
        cords.add(new Point(937, 149));
        cords.add(new Point(996, 181));
        cords.add(new Point(996, 220));
        cords.add(new Point(867, 245));
        cords.add(new Point(900, 290));
        cords.add(new Point(955, 280));
        cords.add(new Point(1033, 287));
        cords.add(new Point(1093, 348));
        cords.add(new Point(1181, 385));
        cords.add(new Point(1440, 405));
        cords.add(new Point(1440, 0));
        cords.add(new Point(930, 0));
        countries[11] = new Country("Russia", cords);

        cords = new ArrayList<>();                                  // Austria Hungary
        cords.add(new Point(890, 304));
        cords.add(new Point(1033, 301));
        cords.add(new Point(1047, 407));
        cords.add(new Point(890, 426));
        cords.add(new Point(859, 493));
        cords.add(new Point(734, 400));
        cords.add(new Point(710, 379));
        cords.add(new Point(658, 383));
        cords.add(new Point(658, 360));
        cords.add(new Point(727, 352));
        cords.add(new Point(756, 327));
        cords.add(new Point(756, 327));
        cords.add(new Point(720, 287));
        cords.add(new Point(773, 280));
        countries[12] = new Country("Austria-Hungary", cords);

        cords = new ArrayList<>();                                  // Switzerland
        cords.add(new Point(564, 355));
        cords.add(new Point(625, 352));
        cords.add(new Point(638, 379));
        cords.add(new Point(561, 383));
        countries[13] = new Country("Switzerland", cords);

        cords = new ArrayList<>();                                  // Italy
        cords.add(new Point(558, 390));
        cords.add(new Point(651, 387));
        cords.add(new Point(720, 402));
        cords.add(new Point(687, 426));
        cords.add(new Point(570, 437));
        cords.add(new Point(631, 451));
        cords.add(new Point(783, 570));
        cords.add(new Point(780, 599));
        cords.add(new Point(687, 603));
        cords.add(new Point(687, 618));
        cords.add(new Point(787, 619));
        cords.add(new Point(860, 553));
        countries[14] = new Country("Italy", cords);

        cords = new ArrayList<>();                                  // Italy
        cords.add(new Point(558, 390));
        cords.add(new Point(651, 387));
        cords.add(new Point(720, 402));
        cords.add(new Point(687, 426));
        cords.add(new Point(860, 553));
        cords.add(new Point(787, 619));
        cords.add(new Point(687, 618));
        cords.add(new Point(687, 603));
        cords.add(new Point(780, 599));
        cords.add(new Point(783, 570));
        cords.add(new Point(631, 451)); // 6
        cords.add(new Point(570, 437)); // 5
        countries[14] = new Country("Italy", cords);

        cords = new ArrayList<>();                                  // Montenegro
        cords.add(new Point(881, 505));
        cords.add(new Point(871, 486));
        cords.add(new Point(882, 475));
        cords.add(new Point(910, 483));
        countries[15] = new Country("Montenegro", cords);

        cords = new ArrayList<>();                                  // Albania
        cords.add(new Point(907, 561));
        cords.add(new Point(888, 509));
        cords.add(new Point(917, 495));
        cords.add(new Point(933, 538));
        countries[16] = new Country("Albania", cords);

        cords = new ArrayList<>();                                  // Greece
        cords.add(new Point(910, 568));
        cords.add(new Point(1003, 665));
        cords.add(new Point(1045, 525));
        cords.add(new Point(995, 521));
        countries[17] = new Country("Greece", cords);

        cords = new ArrayList<>();                                  // Serbia
        cords.add(new Point(940, 528));
        cords.add(new Point(917, 480));
        cords.add(new Point(886, 443));
        cords.add(new Point(973, 436));
        cords.add(new Point(977, 521));
        countries[18] = new Country("Serbia", cords);

        cords = new ArrayList<>();
        cords.add(new Point(1066, 529));
        cords.add(new Point(1085, 505));
        cords.add(new Point(1132, 495));
        cords.add(new Point(1128, 464));
        cords.add(new Point(984, 451));

        cords.add(new Point(996, 518));
        countries[19] = new Country("Bulgaria", cords);



    }
    public void setupMouseListener(){
        addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {
                for (Country c: countries) {
                    if (c != null) {
                        if (c.isClicked(new Point(e.getX(), e.getY())))
                            System.out.println(c.getName());
                    }
                }
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