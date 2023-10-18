package br.com.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.cursomc.security.UserSS;

public class UserService {

	// retorna o usuario que esta logado no sistema
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
