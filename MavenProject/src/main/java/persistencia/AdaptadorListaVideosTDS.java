package persistencia;

import modelo.ListaVideos;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorListaVideosTDS implements	IAdaptadorListaVideosDAO{
	private static ServidorPersistencia servPersistencia;

	private static AdaptadorListaVideosTDS unicaInstancia;

	public static AdaptadorListaVideosTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorListaVideosTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorListaVideosTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	public void registrarListaVideos(ListaVideos lv) {
		// TODO Auto-generated method stub
		
	}

	public ListaVideos recuperarListaVideos(Integer valueOf) {
		// TODO Auto-generated method stub
		return null;
	}
}
