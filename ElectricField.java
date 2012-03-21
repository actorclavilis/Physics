

public abstract class ElectricField implements Field {
	public static final double K = 8.99e9;
	public static final double EP = 1.0/(4.0*Math.PI*K);
	private static class Constant extends GravitationalField {
		Vector strength;
		
		public Vector applyTo(Particle p) {
			return strength.scale(p.m());
		}
	}
	public static GravitationalField withConstant(Vector _strength) {
		Constant c = new Constant();
		c.strength = _strength;
		return c;
	}
	
	private static class FromParticle extends GravitationalField {
		Particle s;
		
		public Vector applyTo(Particle p) {
			double r = s.x().d(p.x());
			double norm = K*s.q()*p.q()/(r*r);
			double arg = s.x().arg() - p.x().arg();
			return Vector.withPolar(norm,arg);
		}
	}
	public static GravitationalField withParticle(Particle _source) {
		FromParticle c = new FromParticle();
		c.s = _source;
		return c;
	}
}