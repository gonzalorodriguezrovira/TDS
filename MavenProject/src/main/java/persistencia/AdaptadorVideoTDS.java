package persistencia;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import modelo.Etiqueta;
import modelo.ListaVideos;
import modelo.Usuario;
import modelo.Video;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorVideoTDS implements IAdaptadorVideoDAO {
	private static ServicioPersistencia servPersistencia;

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

	public void addVideo(Video video) {
		Entidad eVideo = null;
		try {
			eVideo = servPersistencia.recuperarEntidad(video.getCodigo());
		} catch (NullPointerException e) {
		}
		if (eVideo != null)
			return;

		// registrar primero los atributos que son objetos
		AdaptadorEtiquetaTDS adaptadorEtiqueta = AdaptadorEtiquetaTDS.getUnicaInstancia();
		for (Etiqueta e : video.getEtiquetas())
			adaptadorEtiqueta.addListaVideos(e);

		// crear entidad Cliente
		eVideo = new Entidad();
		eVideo.setNombre("video");
		eVideo.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("url", video.getUrl()), new Propiedad("titulo", video.getTitulo()),
						new Propiedad("numRepro", String.valueOf(video.getNumRepro())),
						new Propiedad("etiquetas", obtenercodigoEtiquetas(video.getEtiquetas())))));

		// registrar entidad cliente
		eVideo = servPersistencia.registrarEntidad(eVideo);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		video.setCodigo(eVideo.getId());

	}

	@Override
	public void borrarVideo(Video video) {
		// No se comprueban restricciones de integridad
		Entidad eVideo = servPersistencia.recuperarEntidad(video.getCodigo());
		servPersistencia.borrarEntidad(eVideo);

	}

	@Override
	public void modificarVideo(Video video) {
		// TODO Auto-generated method stub

	}

	@Override
	public Video recuperarVideo(int codigo) {
		// Si la entidad está en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Video) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		Entidad eVideo;
		String url;
		String titulo;
		int numRepro;
		Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();

		eVideo = servPersistencia.recuperarEntidad(codigo);
		url = servPersistencia.recuperarPropiedadEntidad(eVideo, "url");
		titulo = servPersistencia.recuperarPropiedadEntidad(eVideo, "titulo");
		numRepro = Integer.valueOf(servPersistencia.recuperarPropiedadEntidad(eVideo, "numRepro"));
		etiquetas = obtenerEtiquetasDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eVideo, "etiquetas"));

		Video video= new Video(url, titulo, etiquetas);
		usuario.setCodigo(codigo);

		PoolDAO.getUnicaInstancia().addObjeto(codigo, usuario);

		recientes = obtenerRecientesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eVideo, "recientes"));
		listaVideos = obtenerListaVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eVideo, "listaVideos"));

		for (Video v : recientes)
			usuario.addRecientes(v);

		for (ListaVideos lv : listaVideos)
			usuario.addListaVideo(lv);

		if (premium)
			usuario.setPremium(true);

		return usuario;
	}

	@Override
	public List<Video> recuperarVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	// -------------------Funciones auxiliares-----------------------------
	private String obtenercodigoEtiquetas(Set<Etiqueta> etiquetas) {
		String aux = "";
		for (Etiqueta e : etiquetas) {
			aux += e.getNombre() + " ";
		}
		return aux.trim();
	}
	
	private Set<Etiqueta> obtenerEtiquetasDesdeCodigos(String etiquetas) {

		Set<Etiqueta> Etiquetas = new HashSet<Etiqueta>();
		StringTokenizer strTok = new StringTokenizer(etiquetas, " ");
		AdaptadorEtiquetaTDS adaptadorE = AdaptadorEtiquetaTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			Etiquetas.add(adaptadorE.recuperarEtiqueta(Integer.valueOf((String) strTok.nextElement())));
		}
		return Etiquetas;
	}

}
