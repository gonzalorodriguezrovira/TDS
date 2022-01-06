package persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import modelo.ListaVideos;
import modelo.Video;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorListaVideosTDS implements IAdaptadorListaVideosDAO {
	private static ServicioPersistencia servPersistencia;

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

	@Override
	public void addListaVideos(ListaVideos lv) {
		Entidad eListaVideos = null;
		try {
			eListaVideos = servPersistencia.recuperarEntidad(lv.getCodigo());
		} catch (NullPointerException e) {
		}
		if (eListaVideos != null)
			return;
		
		// registrar primero los atributos que son objetos
		AdaptadorVideoTDS adaptadorVideo = AdaptadorVideoTDS.getUnicaInstancia();
		for (Video v : lv.getVideos()) {
			adaptadorVideo.addVideo(v);
		}

		// crear entidad ListaVideo
		eListaVideos = new Entidad();
		eListaVideos.setNombre("ListaVideos");
		eListaVideos.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("name", lv.getName()),
				new Propiedad("videos", obtenerCodigosVideos(lv.getVideos())))));
		// registrar entidad ListaVideos
		eListaVideos = servPersistencia.registrarEntidad(eListaVideos);
		// Para asignar identificador unico se aprovecha el que genera el servicio de
		// persistencia
		lv.setCodigo(eListaVideos.getId());
	}

	@Override
	public void borrarListaVideo(ListaVideos lv) {
		// No se comprueban restricciones de integridad
		Entidad eListaVideos = servPersistencia.recuperarEntidad(lv.getCodigo());
		servPersistencia.borrarEntidad(eListaVideos);
	}

	@Override
	public List<ListaVideos> recuperarListasVideos() {
		List<Entidad> eListasVideos = servPersistencia.recuperarEntidades("ListaVideos");
		List<ListaVideos> listaVideos = new LinkedList<ListaVideos>();

		for (Entidad eListaVideos : eListasVideos) {
			listaVideos.add(recuperarListaVideos(eListaVideos.getId()));
		}
		return listaVideos;
	}

	@Override
	public ListaVideos recuperarListaVideos(int codigo) {
		// Si la entidad está en el pool la devuelve directamente
	
		
		Entidad ListaVideos;
		String name;
		List<Video> videos = new LinkedList<Video>();

		ListaVideos = servPersistencia.recuperarEntidad(codigo);
		name = servPersistencia.recuperarPropiedadEntidad(ListaVideos, "name");
		videos = obtenerVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(ListaVideos, "videos"));
		ListaVideos lv = new ListaVideos(name, videos);

		lv.setCodigo(codigo);

		return lv;
	}

	@Override
	public void modificarListaVideos(ListaVideos lv) {
		Entidad eListaVideo = servPersistencia.recuperarEntidad(lv.getCodigo());

		for (Propiedad prop : eListaVideo.getPropiedades()) {
			
			if (prop.getNombre().equals("codigo")) {
				prop.setValor(String.valueOf(lv.getCodigo()));
			} else if (prop.getNombre().equals("name")) {
				prop.setValor(lv.getName());
			} else if (prop.getNombre().equals("videos")) {
				prop.setValor(obtenerCodigosVideos(lv.getVideos()));
			}
			
			servPersistencia.modificarPropiedad(prop);
		}
	}
	
	// -------------------Funciones auxiliares-----------------------------
	private String obtenerCodigosVideos(List<Video> listaVideo) {
		String aux = "";
		for (Video v : listaVideo) {
			aux += v.getCodigo() + " ";
		}
		return aux.trim();
	}

	private List<Video> obtenerVideosDesdeCodigos(String video) {

		List<Video> Recientes = new LinkedList<Video>();
		StringTokenizer strTok = new StringTokenizer(video, " ");
		AdaptadorVideoTDS adaptadorV = AdaptadorVideoTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			Recientes.add(adaptadorV.recuperarVideo(Integer.valueOf((String) strTok.nextElement())));
		}
		return Recientes;
	}

}
