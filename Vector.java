

public class Vector {
	double x, y;
	
	private Vector(double _x, double _y) {
		x=_x; y=_y;
	}
	public static Vector withRectilinear(double _x, double _y) {
		return new Vector(_x,_y);
	}
	public static Vector withPolar(double _n, double _a) {
		return new Vector(_n*Math.cos(_a), _n*Math.sin(_a));
	}

	public double x() { return x; }
	public double y() { return y; }
	
	public double norm() { return Math.sqrt(x*x+y*y); }
	public double arg() { return Math.atan2(y,x); }
	
	public Vector sum(Vector v) {
		return new Vector(x+v.x, y+v.y);
	}
	public Vector scale(double i) {
		return new Vector(i*x, i*y);
	}
	
	public double in(Vector v) { return x*v.x+y*v.y; }
	public double outN(Vector v) { return norm()*v.norm()*Math.cos(arg()-v.arg()); }
	
	public static final Vector ZERO = Vector.withRectilinear(0,0);
}