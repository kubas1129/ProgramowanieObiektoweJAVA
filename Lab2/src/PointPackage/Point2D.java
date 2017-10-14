package PointPackage;

/**
 * Created by kubas on 13.10.2017.
 */
public class Point2D {
    private double x,y;

    public Point2D(double x_, double y_) {x = x_; y = y_;}

    //Methods

    public double GetX() {return x;}
    public double GetY() {return y;}

    public void SetX(double x_) { x = x_;}
    public void SetY(double y_) { y = y_;}

    public double Distance(Point2D point)
    {
       return (Math.sqrt(Math.pow(this.x - point.GetX(),2) + Math.pow(this.y - point.GetY(),2)));
    }
}
