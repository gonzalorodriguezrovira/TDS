package componente;

import java.util.Vector;

public class ComponenteBuscadorVideos {
	private Vector videosListeners = new Vector();
	private String archivoVideos;
	
	public ComponenteBuscadorVideos() {}
	
	public synchronized void addVideosListener(VideosListener listener) {videosListeners.addElement(listener);}
	public synchronized void removeVideosListener(VideosListener listener) {videosListeners.remove(listener);}
	
	public void setArchivoVideos(String newVideos) {
		EventVideos ev = new EventVideos(this, MapperVideosXMLtoJava.cargarVideos(newVideos));
		notificarNuevosVideos(ev);
	}
	
	public void notificarNuevosVideos(EventVideos evento) {
		Vector lista;
		synchronized (this) {
			lista = (Vector) videosListeners.clone();
		}
		for(int i=0; i<lista.size(); i++){
			VideosListener listener = (VideosListener) lista.elementAt(i);
			listener.nuevosVideos(evento);
		}
	}
	
	public void videosCargados() {
		
	}
}
