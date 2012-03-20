

public class Particle {
	private double m, q;
	
	private Vector x, v;
	
	public Particle(double _m, double _q, Vector _x) {
		m=_m;q=_q;x=_x;
		v=Vector.ZERO;
	}
	
	public Particle(double _m, double _q, Vector _x, Vector _v) {
		this(_m,_q,_x);
		v=_v;
	}
	
	public double m() { return m; }
	public double q() { return q; }
	public Vector x() { return x; }
	public Vector v() { return v; }
}