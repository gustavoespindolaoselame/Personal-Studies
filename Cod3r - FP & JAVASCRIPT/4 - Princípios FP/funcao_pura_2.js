// Uma função pura é uma função em que o valor de retorno é determinado apenas por seus valores de entrada, sem efeitso colaterais observáveis.
//Função impura - devido ao Math.random()
function gerarNumeroAleatorio(min, max){
    const fator = max - min + 1;
    return (parseInt(Math.random() * fator) + min);
}

console.log(gerarNumeroAleatorio(5,6));