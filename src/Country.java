import java.awt.*;
import java.util.ArrayList;

public class Country {
    private ArrayList<Point> points;
    private int[] x, y;
    private String name;
    private Polygon aura;
    private Player owner;
    private int nuTroops;

    public Country(String tag, ArrayList<Point> cords) {
        points = cords;
        name = tag;
        nuTroops = 0;

        x = new int[cords.size()];
        y = new int[cords.size()];

        for (int i = 0; i < cords.size(); i++) {
            x[i] = (int)points.get(i).getX();
            y[i] = (int)points.get(i).getY();
        }

    }

    public void draw(Graphics2D g2) {
        aura = new Polygon(x, y, points.size());

        int midX = (int)((aura.getBounds().getWidth() /2) +aura.getBounds().getX());
        int midY = (int)((aura.getBounds().getHeight() /2) + aura.getBounds().getY());

        g2.setColor(Color.BLACK);
        g2.drawString(name, midX, midY);

        if (owner != null) {
            g2.setColor(owner.getColor());
        } else {
            g2.setColor(Color.GRAY);
        }

        g2.fillOval(midX - 20, midY + 10, 30, 20);

        g2.setColor(Color.WHITE);
        g2.drawString("" + nuTroops, midX - 10, midY + 25);


    }

    public int getTroops() { return nuTroops; }

    public void setTroops(int n) { nuTroops = n;}

    public boolean isClicked(Point point) {
        return (aura.contains(point));
    }

    public void setOwner(Player p) {
        owner = p;

    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}