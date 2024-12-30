/**
 * 
 */
/**
 * 
 */

import br.com.cod3r.app.Calculadora;
import br.com.cod3r.app.calculo.CalculadoraImpl;

module appcalculo {
	exports br.com.cod3r.app.calculo;
	requires applogging;
	opens br.com.cod3r.app.calculo to appfinanceiro;
	requires appapipublica;
	provides Calculadora with CalculadoraImpl;
}