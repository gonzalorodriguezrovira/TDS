package modelo;

import java.util.HashSet;
import java.util.List;

public class FiltroAdultos implements FiltroVideo {
	@Override
	public boolean esVideoOK(List<Video> lv) {
		
		HashSet<Etiqueta> etiquetas = (HashSet<Etiqueta>) lv.getEtiquetas();
		Etiqueta et = etiquetas.stream().filter(e -> e.getNombre().equals("+18")).findAny().orElse(null);
		return et == null;
	}
}
