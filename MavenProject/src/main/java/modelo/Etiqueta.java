package modelo;

public class Etiqueta {
	private int codigo;
	private String nombre;
	
	public Etiqueta(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " - nombre= ["+nombre+"]";
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
