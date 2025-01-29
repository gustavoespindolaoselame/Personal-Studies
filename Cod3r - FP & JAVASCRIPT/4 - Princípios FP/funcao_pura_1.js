// Uma função pura é uma função em que o valor de retorno é determinado apenas por seus valores de entrada, sem efeitso colaterais observáveis.
// Impura - PI é um valor externo!
function areaCirc(raio) {
    return raio * raio * Math.PI
}

console.log(areaCirc(10));

function areaCircPura(raio, PI) {
    return raio * raio * PI
}

console.log(areaCircPura(10, Math.PI));