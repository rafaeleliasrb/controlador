package com.estudos.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet Filter implementation class VerificadorAutenticacao
 */
@WebFilter("/*")
public class VerificadorAutenticacaoFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		boolean isUsuarioNaoLogado = request.getSession().getAttribute("usuarioLogado") == null;
		
		if(isAcaoNecessitaAutenticacao(request.getRequestURI()) && isUsuarioNaoLogado) {
			response.sendRedirect("Login");
			return;
		}

		chain.doFilter(servletRequest, servletResponse);
	}

	private boolean isAcaoNecessitaAutenticacao(String requestURI) {
		String[] uriSplit = requestURI.split("/");
		String acao = StringUtils.capitalize(uriSplit[uriSplit.length-1]);
		
		return !Arrays.asList("Login", "LoginForm", "Logout").contains(acao);
	}


}
