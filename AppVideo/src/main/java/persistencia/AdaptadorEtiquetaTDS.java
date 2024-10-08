package persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import modelo.Etiqueta;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorEtiquetaTDS implements IAdaptadorEtiquetaDAO {

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

	@Override
	public void addEtiqueta(Etiqueta etiqueta) {
		if (etiqueta.getNombre() == null || etiqueta.getNombre().isEmpty())
			return;
		Entidad eEtiqueta = null;
		try {
			eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getCodigo());
		} catch (NullPointerException e) {
		}
		if (eEtiqueta != null) {
			return;
		}
		for (Entidad e : servPersistencia.recuperarEntidades("etiqueta")) {
			if (etiqueta.getNombre().equals(servPersistencia.recuperarPropiedadEntidad(e, "nombre"))) {
				etiqueta.setCodigo(e.getId());
				return;
			}
		}

		eEtiqueta = new Entidad();
		eEtiqueta.setNombre("etiqueta");
		eEtiqueta
				.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", etiqueta.getNombre()))));

		eEtiqueta = servPersistencia.registrarEntidad(eEtiqueta);
		etiqueta.setCodigo(eEtiqueta.getId());
	}

	@Override
	public void borrarEtiqueta(Etiqueta etiqueta) {
		Entidad eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getCodigo());
		servPersistencia.borrarEntidad(eEtiqueta);
	}

	@Override
	public List<Etiqueta> recuperarEtiquetas() {
		List<Entidad> eEtiquetas = servPersistencia.recuperarEntidades("etiqueta");
		List<Etiqueta> etiquetas = new LinkedList<Etiqueta>();

		for (Entidad eEtiqueta : eEtiquetas) {
			etiquetas.add(recuperarEtiqueta(eEtiqueta.getId()));
		}
		return etiquetas;
	}

	@Override
	public Etiqueta recuperarEtiqueta(int codigo) {
		Entidad eEtiqueta;
		String nombre;

		eEtiqueta = servPersistencia.recuperarEntidad(codigo);
		nombre = servPersistencia.recuperarPropiedadEntidad(eEtiqueta, "nombre");

		Etiqueta etiqueta = new Etiqueta(nombre);
		etiqueta.setCodigo(codigo);

		return etiqueta;
	}
}
