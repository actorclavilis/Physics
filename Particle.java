

public class Particle {
	double m, q, x, y;
	
	Vector v;
	
	public Particle(double _m, double _q, double _x, double _y) {
		m=_m;q=_q;x=_x;y=_y;
		v=Vector.ZERO;
	}
	
	public Particle(double _m, double _q, double _x, double _y, Vector _v) {
		this(_m,_q,_x,_y);
		v=_v;
	}
	
}