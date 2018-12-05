package point;
public class Point {
    private double x ;
    private double y;

    public void print()
    {
        System.out.println(x+ " " + y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point (double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    public void trans(int x, int y)
    {
        this.x+=x;
        this.y+=y;

    }
}
