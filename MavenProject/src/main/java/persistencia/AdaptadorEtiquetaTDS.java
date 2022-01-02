package persistencia;

import modelo.Etiqueta;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorEtiquetaTDS implements IAdaptadorEtiquetaDAO{
	private static ServicioPersistencia servPersistencia;

	private static AdaptadorEtiquetaTDS unicaInstancia;

	public static AdaptadorEtiquetaTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorEtiquetaTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorEtiquetaTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		
	}

	public void addListaVideos(Etiqueta e) {
		// TODO Auto-generated method stub
		
	}

	public Etiqueta recuperarEtiqueta(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
}
