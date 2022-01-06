package persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import modelo.Etiqueta;
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
			adaptadorEtiqueta.addEtiqueta(e);

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
		Entidad eVideo = servPersistencia.recuperarEntidad(video.getCodigo());

		for (Propiedad prop : eVideo.getPropiedades()) {
			if (prop.getNombre().equals("codigo")) {
				prop.setValor(String.valueOf(video.getCodigo()));
			} else if (prop.getNombre().equals("url")) {
				prop.setValor(video.getUrl());
			} else if (prop.getNombre().equals("titulo")) {
				prop.setValor(video.getTitulo());
			} else if (prop.getNombre().equals("numRepro")) {
				prop.setValor(String.valueOf(video.getNumRepro()));				
			}else if (prop.getNombre().equals("etiquetas")) {
				prop.setValor(obtenercodigoEtiquetas(video.getEtiquetas()));
			}
				
			servPersistencia.modificarPropiedad(prop);
		}
		

	}

	@Override
	public Video recuperarVideo(int codigo) {
		// Si la entidad está en el pool la devuelve directamente
		

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

		Video video = new Video(url, titulo, etiquetas);
		video.setCodigo(codigo);
		video.setNumRepro(numRepro);

		

		for (Etiqueta e : etiquetas)
			video.addEtiqueta(e);

		return video;
	}

	@Override
	public List<Video> recuperarVideos() {
		List<Entidad> eVideos = servPersistencia.recuperarEntidades("video");
		List<Video> video = new LinkedList<Video>();

		for (Entidad eVideo : eVideos) {
			video.add(recuperarVideo(eVideo.getId()));
		}
		return video;
	}

	// -------------------Funciones auxiliares-----------------------------
	private String obtenercodigoEtiquetas(Set<Etiqueta> etiquetas) {
		String aux = "";
		for (Etiqueta e : etiquetas) {
			aux += e.getCodigo() + " ";
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
