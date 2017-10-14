package PointPackage;


/**
 * Created by kubas on 13.10.2017.
 */
public class Point3D extends Point2D {
    private double z;

    public Point3D(double x_, double y_, double z_)
    {
        super(x_,y_);
        z = z_;
    }

    //Methods

    public double GetZ() {return z;}

    public void SetZ(double z_) {z = z_;}

    public double Distance(Point3D point)
    {
        return Math.sqrt(Math.pow(this.GetX() - point.GetX(),2) + Math.pow(this.GetY() - point.GetY(),2) + Math.pow(this.GetZ() - point.GetZ(),2));
    }
}
