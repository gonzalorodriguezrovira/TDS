package persistencia;

import java.util.List;

import modelo.Etiqueta;

public interface IAdaptadorEtiquetaDAO {
	public void addEtiqueta(Etiqueta etiqueta);
	public void borrarEtiqueta(Etiqueta etiqueta);
	public Etiqueta recuperarEtiqueta(int codigo);
	public List<Etiqueta> recuperarEtiquetas();
	public void modificarEtiqueta(Etiqueta etiqueta);
}
