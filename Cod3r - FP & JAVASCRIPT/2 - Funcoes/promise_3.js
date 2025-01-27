function gerarNumerosEntre(min,max) {
    if(min > max){
        [max,min] = [min, max]
    }
    return new Promise(resolve => {
        const fator = (max - min)
        const aleatorio = parseFloat(Math.random() * fator) + min
        resolve(aleatorio)
    })
}
gerarNumerosEntre(1,60).then(num => console.log(`O número gerado foi ${num}`))