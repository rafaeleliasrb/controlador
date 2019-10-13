package com.estudos.acoes;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.estudos.autenticate.Autenticador;
import com.estudos.core.Acao;
import com.estudos.core.TipoAcaoEnum;
import com.estudos.exceptions.SenhaErradaException;
import com.estudos.exceptions.UsuarioNaoEncontradoException;
import com.estudos.models.Usuario;

public class LoginForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		String errorMessage = null;
		
		Optional<Usuario> usuario = Optional.empty();
		try {
			usuario = Autenticador.autenticarUsuario(login, senha);
		} catch (UsuarioNaoEncontradoException | SenhaErradaException e) {
			errorMessage = e.getMessage();
		}
		
		if(usuario.isPresent()) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario.get());
			return TipoAcaoEnum.REDIRECT.getTipoAcao() + ":Home";
		} else {
			request.getSession().setAttribute("errorMessage", errorMessage);
			return TipoAcaoEnum.FORWARD.getTipoAcao() + ":loginForm.jsp";
		}
	}

}
