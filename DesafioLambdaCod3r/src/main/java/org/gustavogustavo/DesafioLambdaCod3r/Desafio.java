/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.gustavogustavo.DesafioLambdaCod3r;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Desafio Expressões lambda do curso da coder, apenas comecei a documentar a partir daqui.
 * @author gustavo
 */
public class Desafio {

    public static void main(String[] args) {
        Produto p = new Produto("iPad", 3235.89, 0.13);

        BinaryOperator<Double> precoReal = (preco, desconto) -> preco * (1-desconto);
        UnaryOperator<Double> adicionarImpostoMunicipal = preco -> preco >= 2500 ? preco * 1.085 : preco;
        UnaryOperator<Double> adicionarFrete = preco -> (preco >= 3000) ? preco + 100.0 : preco + 50.0;
        UnaryOperator<Double> arrendondar = preco -> preco = (double) Math.round(preco);
        Function<Double, String> formatar = preco -> "R$:".concat(preco.toString());

        System.out.println(
            precoReal.andThen(adicionarImpostoMunicipal.andThen(
                adicionarFrete.andThen(
                    arrendondar.andThen(
                        formatar)))).apply(
                            p.getPreco(), p.getDesconto())
        );
    }
}
