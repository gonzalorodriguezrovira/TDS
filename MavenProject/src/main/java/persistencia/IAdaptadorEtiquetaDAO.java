package persistencia;

import java.util.List;

import modelo.Etiqueta;

public interface IAdaptadorEtiquetaDAO {
	public void addEtiqueta(Etiqueta lv);
	public void borrarEtiqueta(Etiqueta lv);
	public Etiqueta recuperarEtiqueta(int codigo);
	public List<Etiqueta> recuperarEtiqueta();
	public void modificarEtiqueta(Etiqueta lv);
}
