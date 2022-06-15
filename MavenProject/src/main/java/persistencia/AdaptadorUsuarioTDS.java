package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import modelo.ListaVideos;
import modelo.Usuario;
import modelo.Video;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO {

	private static ServicioPersistencia servPersistencia;

	private SimpleDateFormat dateFormat;

	private static AdaptadorUsuarioTDS unicaInstancia;

	public static AdaptadorUsuarioTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorUsuarioTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public void addUsuario(Usuario usuario) {
		Entidad eUsuario = null;
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		} catch (NullPointerException e) {
		}
		if (eUsuario != null)
			return;

		AdaptadorListaVideosTDS adaptadorListaVideos = AdaptadorListaVideosTDS.getUnicaInstancia();
		for (ListaVideos lv : usuario.getListaVideos())
			adaptadorListaVideos.addListaVideos(lv);

		AdaptadorVideoTDS adaptadorVideo = AdaptadorVideoTDS.getUnicaInstancia();
		for (Video v : usuario.getRecientes())
			adaptadorVideo.addVideo(v);

		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", usuario.getNombre()),
				new Propiedad("apellidos", usuario.getApellidos()), new Propiedad("email", usuario.getEmail()),
				new Propiedad("tamHistorial", String.valueOf(usuario.getTamHistorial())),
				new Propiedad("usuario", usuario.getUsuario()), new Propiedad("password", usuario.getPassword()),
				new Propiedad("listaVideos", obtenerCodigosListaVideos(usuario.getListaVideos())),
				new Propiedad("recientes", obtenerCodigosVideos(usuario.getRecientes())),
				new Propiedad("premium", String.valueOf(usuario.isPremium())),
				new Propiedad("nacimiento", dateFormat.format(usuario.getNacimiento())))));

		eUsuario = servPersistencia.registrarEntidad(eUsuario);

		usuario.setCodigo(eUsuario.getId());

	}

	@Override
	public void borrarUsuario(Usuario usuario) {

		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		servPersistencia.borrarEntidad(eUsuario);
	}

	@Override
	public Usuario recuperarUsuario(int codigo) {

		Entidad eUsuario;
		String nombre;
		String apellidos;
		String email;
		String user;
		String password;
		Date nacimiento = new Date();
		boolean premium;

		List<ListaVideos> listaVideos = new LinkedList<ListaVideos>();
		List<Video> recientes = new LinkedList<Video>();
		int tamHistorial;

		eUsuario = servPersistencia.recuperarEntidad(codigo);
		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		apellidos = servPersistencia.recuperarPropiedadEntidad(eUsuario, "apellidos");
		email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		user = servPersistencia.recuperarPropiedadEntidad(eUsuario, "usuario");
		password = servPersistencia.recuperarPropiedadEntidad(eUsuario, "password");
		try {
			nacimiento = dateFormat.parse(servPersistencia.recuperarPropiedadEntidad(eUsuario, "nacimiento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		premium = Boolean.valueOf(servPersistencia.recuperarPropiedadEntidad(eUsuario, "premium"));
		tamHistorial = Integer.valueOf(servPersistencia.recuperarPropiedadEntidad(eUsuario, "tamHistorial"));

		Usuario usuario = new Usuario(nombre, apellidos, email, tamHistorial, user, password, nacimiento);
		usuario.setCodigo(codigo);

		recientes = obtenerRecientesDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "recientes"));
		listaVideos = obtenerListaVideosDesdeCodigos(
				servPersistencia.recuperarPropiedadEntidad(eUsuario, "listaVideos"));
		for (Video v : recientes)
			usuario.addRecientes(v);

		for (ListaVideos lv : listaVideos)
			usuario.addListaVideo(lv);

		if (premium)
			usuario.setPremium(true);

		return usuario;
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("usuario");
		List<Usuario> usuarios = new LinkedList<Usuario>();

		for (Entidad eUsuario : eUsuarios) {
			usuarios.add(recuperarUsuario(eUsuario.getId()));
		}
		return usuarios;
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());

		for (Propiedad prop : eUsuario.getPropiedades()) {

			if (prop.getNombre().equals("codigo")) {
				prop.setValor(String.valueOf(usuario.getCodigo()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(usuario.getNombre());
			} else if (prop.getNombre().equals("apellidos")) {
				prop.setValor(usuario.getApellidos());
			} else if (prop.getNombre().equals("email")) {
				prop.setValor(usuario.getEmail());
			} else if (prop.getNombre().equals("usuario")) {
				prop.setValor(usuario.getUsuario());
			} else if (prop.getNombre().equals("password")) {
				prop.setValor(usuario.getPassword());
			} else if (prop.getNombre().equals("nacimiento")) {
				prop.setValor(dateFormat.format(usuario.getNacimiento()));
			} else if (prop.getNombre().equals("premium")) {
				prop.setValor(String.valueOf(usuario.isPremium()));
			} else if (prop.getNombre().equals("listaVideos")) {
				String str = obtenerCodigosListaVideos(usuario.getListaVideos());
				if (str != null)
					prop.setValor(str);
			} else if (prop.getNombre().equals("recientes")) {
				String str = obtenerCodigosVideos(usuario.getRecientes());
				if (str != null)
					prop.setValor(str);
			} else if (prop.getNombre().equals("tamHistorial")) {
				prop.setValor(String.valueOf(usuario.getTamHistorial()));
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

	private String obtenerCodigosListaVideos(List<ListaVideos> listaVideos) {
		String aux = "";
		for (ListaVideos lv : listaVideos) {
			aux += lv.getCodigo() + " ";
		}
		return aux.trim();
	}

	private List<Video> obtenerRecientesDesdeCodigos(String video) {

		List<Video> Recientes = new LinkedList<Video>();
		StringTokenizer strTok = new StringTokenizer(video, " ");
		AdaptadorVideoTDS adaptadorV = AdaptadorVideoTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			Recientes.add(adaptadorV.recuperarVideo(Integer.valueOf((String) strTok.nextElement())));
		}
		return Recientes;
	}

	private List<ListaVideos> obtenerListaVideosDesdeCodigos(String listaVideos) {

		List<ListaVideos> lv = new LinkedList<ListaVideos>();
		StringTokenizer strTok = new StringTokenizer(listaVideos, " ");
		AdaptadorListaVideosTDS adaptadorLV = AdaptadorListaVideosTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			lv.add(adaptadorLV.recuperarListaVideos(Integer.valueOf((String) strTok.nextElement())));
		}
		return lv;
	}

}
