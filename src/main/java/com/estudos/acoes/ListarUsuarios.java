package com.estudos.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudos.core.Acao;
import com.estudos.core.TipoAcaoEnum;
import com.estudos.repositories.UsuarioRepository;

public class ListarUsuarios implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("usuarios", new UsuarioRepository().getUsuarios());
		return TipoAcaoEnum.FORWARD.getTipoAcao() + ":listarUsuarios.jsp";
	}

}
