package persistencia;

import java.util.List;

import modelo.Usuario;

public interface IAdaptadorUsuarioDAO {
	public void addUsuario(Usuario usuario);
	public void borrarUsuario(Usuario usuario);
	public Usuario recuperarUsuario(int codigo);
	public List<Usuario> recuperarUsuarios();
	public void modificarUsuario(Usuario usuario);
}
