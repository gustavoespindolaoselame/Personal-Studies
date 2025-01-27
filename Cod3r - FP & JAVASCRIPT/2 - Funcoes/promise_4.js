function gerarNumerosEntre(min,max,timeout) {
    if(min > max){
        [max,min] = [min, max]
    }
    return new Promise(resolve => {
        setTimeout(() => {
        const fator = (max - min)
        const aleatorio = parseFloat(Math.random() * fator) + min
        resolve(aleatorio)
        }, timeout);
    })
}

function gerarVariosNumeros(){
    return Promise.all([
        gerarNumerosEntre(1,60,1000),
        gerarNumerosEntre(1,50,400),
        gerarNumerosEntre(1,20,300),
        gerarNumerosEntre(100,600,5000)
    ])
}

console.time('promise')
gerarVariosNumeros().then(numeros => console.log(numeros)).then(()=>{
    console.timeLog('promise')
    console.timeEnd('promise')
})

