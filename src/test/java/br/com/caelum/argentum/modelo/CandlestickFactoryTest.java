package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() {
		
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
		negociacao3, negociacao4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void sequenciaCrescenteDeValor() {
		
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(46.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(47.3, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
		negociacao3, negociacao4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(47.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(47.3, candle.getMaximo(), 0.00001);
		Assert.assertEquals(17960.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void sequenciaDecrescenteDeValor() {
		
		Calendar hoje = Calendar.getInstance();
	
		Negociacao negociacao1 = new Negociacao(47.3, 100, hoje);
		Negociacao negociacao2 = new Negociacao(46.8, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(40.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
		negociacao3, negociacao4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(47.3, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(47.3, candle.getMaximo(), 0.00001);
		Assert.assertEquals(17910.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComAberturaZero() {
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComFechamentoZero() {
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComMinimoZero() {
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComMaximoZero() {
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
	}
	
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}
	
}
