import java.awt.*;

public class Country {
    private int[] intX;
    private int[] intY;
    private int nuSide;

    public Country(int[] xCords, int[] yCords) {
        intX = xCords;
        intY = yCords;

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.drawPolygon(intX, intY, intX.length);




    }



}
