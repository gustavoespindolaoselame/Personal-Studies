function gerarNumerosEntre(min,max, numerosProibidos) {
    if(min > max){
        [max,min] = [min, max];
    }
    return new Promise((resolve, reject) => {
        const fator = (max - min);
        const aleatorio = parseInt(Math.random() * fator) + min;
        if(numerosProibidos.includes(aleatorio)){
            reject("Número repetido")
        }
        resolve(aleatorio);
    })
}

async function gerarMegaSena(qtdeNumeros, tentativas = 10){
    try {
        const numeros = [];
        for(let _ of Array(qtdeNumeros).fill()){
            numeros.push(await gerarNumerosEntre(1,60, numeros));
        }
        return numeros;
    } catch (e){
        if(tentativas>=0){
            return gerarMegaSena(qtdeNumeros, tentativas-1)
        } else {
            throw "Err"
        }
    }
}

gerarMegaSena(16).then(console.log).catch(console.log)
// gerarNumerosEntre(1,5,[1,2,3,4,5]).then(num => console.log(`O número gerado foi ${num}`)).catch(console.log);