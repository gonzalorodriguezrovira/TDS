package componente;

import java.util.EventObject;

public class EventVideos extends EventObject{
	Videos videos;
	public EventVideos(Object fuente, Videos videos) {
		super(fuente);
		this.videos = videos;
	}
	
	public Videos getVideos() {
		return videos;
	}
}
