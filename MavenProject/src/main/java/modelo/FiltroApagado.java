package modelo;

public class FiltroApagado implements FiltroVideo {
	@Override
	public boolean esVideoOK(Video v) {
		return true;
	}
}
