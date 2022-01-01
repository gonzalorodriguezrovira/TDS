package persistencia;

import java.text.SimpleDateFormat;

import modelo.Video;
import tds.driver.FactoriaServicioPersistencia;

public class AdaptadorVideoTDS implements IAdaptadorVideoDAO{
	private static ServidorPersistencia servPersistencia;



	private static AdaptadorVideoTDS unicaInstancia;

	public static AdaptadorVideoTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorVideoTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorVideoTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		
	}

	public Video recuperarVideo(Integer valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarVideo(Video v) {
		// TODO Auto-generated method stub
		
	}
}
