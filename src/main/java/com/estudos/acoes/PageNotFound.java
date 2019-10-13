package com.estudos.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudos.core.Acao;

public class PageNotFound implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "forward:pageNotFound.jsp";
	}

}
