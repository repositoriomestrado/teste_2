package br.com.wtsyst.controle.impl;

import org.springframework.stereotype.Controller;

import br.com.wtsyst.controle.CalcBCI;

@Controller
public class CalcBC implements CalcBCI {

	@Override
	public Integer somar(Integer a, Integer b) {
		
		return a+b;
	}
	
}
