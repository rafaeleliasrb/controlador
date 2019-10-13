package com.estudos.core;

public class EnderecoTipo {
	private static final String PASTA = "WEB-INF/view/";
	
	private String tipo;
	private String endereco;
	private String mensagemErro;
	
	public EnderecoTipo(String acao) {
		String[] tipoEEndereco = acao.split(":");
		tipo = TipoAcaoEnum.getTipoAcaoEnum(tipoEEndereco[0]).getTipoAcao();
		endereco = tipoEEndereco[1];
	}
	
	public boolean isRedirect() {
		return tipo.equalsIgnoreCase(TipoAcaoEnum.REDIRECT.getTipoAcao());
	}
	
	public boolean isForward() {
		return tipo.equalsIgnoreCase(TipoAcaoEnum.FORWARD.getTipoAcao());
	}
	
	public String getEndereco() {
		return isForward()? (PASTA + endereco) : endereco;
	}
	
	public String getMensagemErro() {
		return mensagemErro;
	}
}
