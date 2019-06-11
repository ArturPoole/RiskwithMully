import java.awt.*;

public class Country {
    private Point[] points;
    private int[] x, y;
    private int nuSide;
    private String name;
    private Polygon aura;

    public Country(String tag, Point[] cords) {
        points = cords;
        name = tag;
        x = new int[cords.length];
        y = new int[cords.length];

        for (int i = 0; i < cords.length; i++) {
            x[i] = (int)points[i].getX();
            y[i] = (int)points[i].getY();

        }

        for (int i = 0; i < x.length ; i++) {
            for (int j = 0; j < y.length ; j++) {
                System.out.println(x[i] + " " + y[i]);
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        aura = new Polygon(x, y, points.length);
        g2.fill(aura);

    }

    public boolean isClicked(Point point) { return (aura.contains(point)); }



}
