package modelo;

public class FiltroNoFiltro implements FiltroVideo {
	@Override
	public boolean esVideoOK(Video v) {
		return true;
	}
}
