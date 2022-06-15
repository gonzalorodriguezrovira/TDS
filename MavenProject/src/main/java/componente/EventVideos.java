package componente;

import java.util.EventObject;

public class EventVideos extends EventObject{
	
	private static final long serialVersionUID = 1L;
	Videos videos;
	public EventVideos(Object fuente, Videos videos) {
		super(fuente);
		this.videos = videos;
	}
	
	public Videos getVideos() {
		return videos;
	}
}
