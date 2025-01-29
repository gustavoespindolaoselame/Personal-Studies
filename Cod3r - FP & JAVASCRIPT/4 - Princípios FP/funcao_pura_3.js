// Uma função pura é uma função em que o valor de retorno é determinado apenas por seus valores de entrada, sem efeitso colaterais observáveis.
// Função pura!
function somar(a, b) {
    return a + b;
}

console.log(somar(68, 31));

let qtdeDeExecucoes = 0;

// Função impura!
function subtracao(a, b) {
    qtdeDeExecucoes++;
    return a + b;
}

console.log(subtracao(68, 31));
console.log(subtracao(68, 31));
console.log(subtracao(68, 31));
console.log(qtdeDeExecucoes);