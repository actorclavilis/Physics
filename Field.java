

public interface Field {
	public Vector applyTo(Particle p);
	
	public static class LimitedField implements Field {
		private Field sub;
		private double xi, xa, yi, ya;
		
		public LimitedField(Field _sub, double _xi, double _xa, double _yi, double _ya) {
			sub = _sub;
			xi=_xi; xa=_xa; yi=_yi; ya=_ya;
		}
		
		public Vector applyTo(Particle p) {
			if(p.x().x<xi || p.x().x>=xa)
				return Vector.ZERO;
			if(p.x().y<yi || p.x().y>=ya)				return Vector.ZERO;
			return sub.applyTo(p);
		}
	}
}