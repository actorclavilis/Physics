

public abstract class ElectricField implements Field {
	public static final double K = 8.99e9;
	public static final double EP = 1.0/(4.0*Math.PI*K);
	private static class Constant extends ElectricField {
		Vector strength;
		
		public Vector applyTo(Particle p) {
			return strength.scale(p.q());
		}
	}
	
	private static class FromParticle extends ElectricField {
		Particle s;
		
		public Vector applyTo(Particle p) {
			double r = s.x().d(p.x());
			double norm = K*s.q()*p.q()/(r*r);
			double arg = s.x().arg() - p.x().arg();
			return Vector.withPolar(norm,arg);
		}
	}
}