package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {
	
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		this.preco = preco;
		this.data = data;
		this.quantidade = quantidade;
	}
	
	public double getVolume() {
		return preco * quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		//clone retorna um objeto imtavel
		return (Calendar) this.data.clone();
	}
	
	/*Sem clone, precisaríamos fazer esse processo na mão. Com Calendar é relativamente fácil:
	public Calendar getData() {
		Calendar copia = Calendar.getInstance();
		copia.setTimeInMillis(this.data.getTimeInMillis());
		return copia;
	}*/
	
	
}
