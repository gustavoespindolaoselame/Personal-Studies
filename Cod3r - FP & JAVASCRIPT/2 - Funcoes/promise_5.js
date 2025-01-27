function funcionarOuNao(valor, chanceErro){
    return new Promise((resolve, reject) =>{
        if(Math.random() < chanceErro){
            reject("Ocorreu um erro!!")
        } else {
            resolve(valor)
        }
    })
}

funcionarOuNao("testando", 0.5).
    then(v => console.log(v)).
    catch(err => console.log(err)).
    then(() => console.log("Fim"))
    