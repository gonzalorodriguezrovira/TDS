package modelo;

import java.util.HashSet;

public class FiltroAdultos implements FiltroVideo {
	@Override
	public boolean esVideoOK(Video v) {
		HashSet<Etiqueta> etiquetas = (HashSet<Etiqueta>) v.getEtiquetas();
		Etiqueta et = etiquetas.stream().filter(e -> e.getNombre().equals("+18")).findAny().orElse(null);
		return et == null;
	}
}
