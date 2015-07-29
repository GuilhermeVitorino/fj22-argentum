package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	// ctrl + 1 para adicionar o return automaticamente
	public Candlestick constroiCandleParaData(Calendar data,
										List<Negociacao> negociacoes) {
		//double maximo = negociacoes.get(0).getPreco();
		//double minimo = negociacoes.get(0).getPreco();
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		
		double volume = 0;
		
		// digite foreach e d� um ctrl + espa�o para ajudar a
		// criar o bloco abaixo!
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
		
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}
			
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 :
							negociacoes.get(negociacoes.size() - 1).getPreco();
		if(negociacoes.isEmpty())
			minimo=0;
		//double abertura = negociacoes.get(0).getPreco();
		//double fechamento = negociacoes.get(negociacoes.size()-1).getPreco();
		System.out.println(minimo);
		return new Candlestick(abertura, fechamento, minimo, maximo,
														volume, data);
				
	}
}
