package umu.tds;

import umu.tds.repositorios.RepositorioUsuario;

public class RepUserTest {
	
	public static void main(String[] args) {
		RepositorioUsuario repo = new RepositorioUsuario();
		System.out.println(repo.addUsuario("juan", "juanito", "juan", "j"));
		System.out.println(repo.addUsuario("juan", "juanito", "juan", "j"));
		System.out.println(repo.addUsuario("juan", "juanito", "juana", "j"));
		
		System.out.println(repo.findUsuario("juan"));
		
	}
}
