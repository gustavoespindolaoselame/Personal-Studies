package br.com.cod3r.app.financeiro;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.cod3r.app.Calculadora;

public class Teste {
	public static void main(String[] args) {
		Calculadora calc = ServiceLoader.
				load(Calculadora.class).
				findFirst().
				get();
		System.out.println(calc.soma(1,2,3,4));
		
		Field fieldId = calc.getClass().getDeclaredFields()[0];
		try {
			fieldId.setAccessible(true);
			System.out.println(fieldId.get(calc));
			fieldId.set(calc,  "def");
			System.out.println(fieldId.get(calc));
			fieldId.setAccessible(false);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
