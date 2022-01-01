package persistencia;

import java.util.List;

import modelo.Usuario;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO {

	private static ServidorPersistencia servPersistencia;

	private static AdaptadorUsuarioTDS unicaInstancia;

	public static AdaptadorUsuarioTDS getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}

	@Override
	public void addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findUsuario(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

//	private static Servici
}
