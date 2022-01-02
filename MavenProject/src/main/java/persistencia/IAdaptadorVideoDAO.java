package persistencia;

import java.util.List;

import modelo.Video;

public interface IAdaptadorVideoDAO {
	public void addVideo(Video video);

	public void borrarVideo(Video video);

	public void modificarVideo(Video video);

	public Video recuperarVideo(int codigo);

	public List<Video> recuperarVideo();
}
