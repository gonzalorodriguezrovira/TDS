package modelo;

public class Etiqueta {
	// ATRIBUTOS
	private int codigo;
	private String nombre;

	// CONSTRUCTOR
	public Etiqueta(String nombre) {
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etiqueta otro = (Etiqueta) obj;
		
		return otro.getNombre() == nombre;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " - nombre= [" + nombre + "]";
	}
}
