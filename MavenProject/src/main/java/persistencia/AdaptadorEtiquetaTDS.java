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
		Entidad eEtiqueta = null;
		try {
			eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getCodigo());
		} catch (NullPointerException e) {
		}
		if (eEtiqueta != null)
			return;

		eEtiqueta = new Entidad();
		eEtiqueta.setNombre(etiqueta.getNombre());
		eEtiqueta
				.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre", etiqueta.getNombre()))));

		// registrar entidad Etiqueta
		eEtiqueta = servPersistencia.registrarEntidad(eEtiqueta);
		// Para asignar identificador unico se aprovecha el que genera el servicio de
		// persistencia
		etiqueta.setCodigo(eEtiqueta.getId());
	}

	@Override
	public void borrarEtiqueta(Etiqueta etiqueta) {
		// No se comprueban restricciones de integridad
		Entidad eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getCodigo());
		servPersistencia.borrarEntidad(eEtiqueta);
	}

	@Override
	public void modificarEtiqueta(Etiqueta etiqueta) {
		Entidad eEtiqueta = servPersistencia.recuperarEntidad(etiqueta.getCodigo());
		for (Propiedad prop : eEtiqueta.getPropiedades()) {

			if (prop.getNombre().equals("codigo")) {
				prop.setValor(String.valueOf(etiqueta.getCodigo()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(etiqueta.getNombre());
			}

			servPersistencia.modificarPropiedad(prop);
		}
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
		nombre = eEtiqueta.getNombre();
		
		Etiqueta etiqueta = new Etiqueta(nombre);
		etiqueta.setCodigo(codigo);
		
		return etiqueta;
	}
}
