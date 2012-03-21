

public abstract class MagneticField implements Field {
	public static final double MU = Math.PI*4e-7;
	private static class Constant extends MagneticField {
		double strength;
		
		public Vector applyTo(Particle p) {
			double arg = p.x().arg() + Math.PI*(strength < 0 ? - 1 : 1);
			double norm = p.x().norm()*Math.abs(strength);
			return Vector.withPolar(arg,norm);
		}
	}
	public static MagneticField withConstant(double _strength) {
		Constant c = new Constant();
		c.strength = _strength;
		return c;
	}
}