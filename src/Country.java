import java.awt.*;
import java.util.ArrayList;

public class Country {
    private ArrayList<Point> points;
    private int[] x, y;
    private String name;
    private Polygon aura;

    public Country(String tag, ArrayList<Point> cords) {
        points = cords;

        x = new int[cords.size()];
        y = new int[cords.size()];

        for (int i = 0; i < cords.size(); i++) {
            x[i] = (int)points.get(i).getX();
            y[i] = (int)points.get(i).getY();
            System.out.println(x[i]);
            System.out.println(y[i]);

        }

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        aura = new Polygon(x, y, points.size());
        g2.fill(aura);

    }

    public boolean isClicked(Point point) {
        return (aura.contains(point));
    }

    public String getName() {
        return name;
    }
}