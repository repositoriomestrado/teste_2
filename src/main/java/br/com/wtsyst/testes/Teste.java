package br.com.wtsyst.testes;

import br.com.wtsyst.controle.CalcBCI;
import br.com.wtsyst.controle.impl.CalcBC;


public class Teste {

	CalcBCI calc = new CalcBC();

	
	public void teste() {
		Integer resultado = calc.somar(5, 5);
		Integer esperado = 10;

	//	Assert.assertEquals(esperado, resultado);

	}

}
