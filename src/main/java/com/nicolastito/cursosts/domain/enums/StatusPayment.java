package com.nicolastito.cursosts.domain.enums;

public enum StatusPayment {

	PENDENTE (1, "Pendente"),
	QUITADO (2, "Quitado"),
	CANCELADO (3, "Cancelado");

	private int cod;
	private String descricao;

	private StatusPayment(int cod, String descricao){
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao(){
		return descricao;
	}

	public static StatusPayment toEnum(Integer cod){
		if (cod == null){
			return null;
		}

		for (StatusPayment x : StatusPayment.values()){
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid ID: " + cod);
	}
}
