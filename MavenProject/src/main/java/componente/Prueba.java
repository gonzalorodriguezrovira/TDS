package componente;

import java.util.EventObject;

import javax.swing.JFrame;

public class Prueba {
	private static Videos videos;
	private static EventVideos ev;
	public static void main(String[] args) {
		Videos videos;
		ComponenteBuscadorVideos compo = new ComponenteBuscadorVideos();
		compo.addVideosListener(new VideosListener() {
			@Override
			public void nuevosVideos(EventObject e) {
				ev = (EventVideos)e;
			}
		});
		compo.setArchivoVideos("xml/videos.xml");
		ev.getVideos().getVideo().stream().map(v -> v.getTitulo()).forEach(System.out::println);
	}
}
