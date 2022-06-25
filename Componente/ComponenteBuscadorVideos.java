package componente;

import java.util.Vector;

public class ComponenteBuscadorVideos {
	private Vector<VideosListener> videosListeners = new Vector<VideosListener>();
	private static ComponenteBuscadorVideos unicaInstancia;
	
	public static ComponenteBuscadorVideos getUnicaInstancia() {
		
		if (unicaInstancia == null)
			unicaInstancia = new ComponenteBuscadorVideos();
		return unicaInstancia;
	}
	
	public ComponenteBuscadorVideos() {}
	
	public synchronized void addVideosListener(VideosListener listener) {videosListeners.addElement(listener);}
	public synchronized void removeVideosListener(VideosListener listener) {videosListeners.remove(listener);}
	
	public void setArchivoVideos(String newVideos) {
		EventVideos ev = new EventVideos(this, MapperVideosXMLtoJava.cargarVideos(newVideos));
		notificarNuevosVideos(ev);
	}
	
	@SuppressWarnings("unchecked")
	public void notificarNuevosVideos(EventVideos evento) {
		Vector<VideosListener> lista;
		synchronized (this) {
			lista = (Vector<VideosListener>) videosListeners.clone();
		}
		for(int i=0; i<lista.size(); i++){
			VideosListener listener = (VideosListener) lista.elementAt(i);
			listener.nuevosVideos(evento);
		}
	}
	
}
