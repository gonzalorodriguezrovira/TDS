package modelo;

import java.util.LinkedList;
import java.util.List;

import controlador.App;

public class FiltroMisListas implements FiltroVideo{
	@Override
	public boolean esVideoOK(Video v) {
		List<ListaVideos> llv = App.getInstancia().getUsuarioActual().getListaVideos();
		List<Video> l = new LinkedList<Video>();
		for (ListaVideos lv : llv) {
			l.addAll(lv.getVideos());
		}
		return l.contains(v);
	}
}
