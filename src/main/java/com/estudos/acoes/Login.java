package com.estudos.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estudos.core.Acao;
import com.estudos.core.TipoAcaoEnum;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return TipoAcaoEnum.FORWARD.getTipoAcao()+ ":loginForm.jsp";
	}

}
