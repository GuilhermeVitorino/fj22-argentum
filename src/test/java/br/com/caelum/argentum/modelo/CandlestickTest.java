package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Candlestick (40.5, 45.8,  43.2, 42.2, 100,Calendar.getInstance());
	}

}
