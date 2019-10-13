package com.estudos.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/")
public class ControlServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String PAGE_NOT_FOUND = "pageNotFound.jsp";
	private static final String CAMINHO = "com.estudos.acoes.";

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	removeErrorMessage(request.getSession());
		try {
			EnderecoTipo tipoEndereco = 
					new EnderecoTipo(getAcaoASerExecutada(request.getRequestURI()).executa(request, response));
			
			if(tipoEndereco.isRedirect())
				response.sendRedirect(tipoEndereco.getEndereco());
			else if(tipoEndereco.isForward()) 
				request.getRequestDispatcher(tipoEndereco.getEndereco()).forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			redirectPageNotFound(request, response);
		}
		
	}

	private void removeErrorMessage(HttpSession session) {
		session.removeAttribute("errorMessage");
	}

	@SuppressWarnings("unchecked")
	private Acao getAcaoASerExecutada(String uri) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String[] split = uri.split("/");
		
		Class<Acao> acao = (Class<Acao>) Class.forName(CAMINHO + StringUtils.capitalize(split[split.length-1]));

		return acao.newInstance();
	}
	
	private void redirectPageNotFound(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher(PAGE_NOT_FOUND).forward(request, response);
	}
}
