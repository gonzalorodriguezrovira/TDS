package persistencia;

import java.util.List;

import modelo.ListaVideos;

public interface IAdaptadorListaVideosDAO {
	public void addListaVideos(ListaVideos lv);

	public void borrarListaVideo(ListaVideos lv);

	public ListaVideos recuperarListaVideos(int codigo);

	public List<ListaVideos> recuperarListasVideos();

	public void modificarListaVideos(ListaVideos lv);
}
