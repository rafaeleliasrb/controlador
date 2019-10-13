package com.estudos.core;

public enum TipoAcaoEnum {

	REDIRECT("redirect"),
	FORWARD("forward");
	
	private String tipoAcao;
	
	private TipoAcaoEnum(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}
	
	public String getTipoAcao() {
		return tipoAcao;
	}
	
	public static TipoAcaoEnum getTipoAcaoEnum(String tipoAcao) {
		if(REDIRECT.tipoAcao.equalsIgnoreCase(tipoAcao)) {
			return REDIRECT;
		}
		else if(FORWARD.tipoAcao.equalsIgnoreCase(tipoAcao)) {
			return FORWARD;
		}
		throw new RuntimeException("Ação selecionada não existe");
	}
}
