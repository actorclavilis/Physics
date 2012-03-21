

public abstract class GravitationalField implements Field {
	public static final double G = 6.67384e-11;
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
			double norm = G*s.m()*p.m()/(r*r);
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