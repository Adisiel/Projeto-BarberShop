package controller;

import model.DAO.UsuarioDAO;
import model.bean.Usuario;
import view.ViewLogin;

public class ControllerFormLogin {
	ViewLogin view;
	
	public ControllerFormLogin(ViewLogin view) {
		this.view = view;
	}
	
	public boolean autenticacao() {
		UsuarioDAO uDAO = new UsuarioDAO();
		String user = view.getTextUsuario().getText();
		String password = new String(view.getTextSenha().getPassword());
		boolean autenticado = false;
		for(Usuario u: uDAO.selectAll()) {
			if (u.getUser().equals(user) && u.getPassword().equals(password)) {
				autenticado = true;
				return autenticado;
				}
			}
		return autenticado;
	}
}
