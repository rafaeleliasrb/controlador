package com.estudos.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudos.core.Acao;
import com.estudos.core.TipoAcaoEnum;

public class Home implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return TipoAcaoEnum.FORWARD.getTipoAcao()+ ":home.jsp";
	}

}
