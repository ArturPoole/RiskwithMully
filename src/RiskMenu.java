import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RiskMenu extends JPanel {
    private BufferedImage worldMapBackground;

    public RiskMenu(int w, int h) {
        setSize(w, h);


        try{
            worldMapBackground = ImageIO.read(new File("res/worldMap.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(worldMapBackground, 0, 0, null);
    }

}
