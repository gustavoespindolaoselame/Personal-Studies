function esperarPor(tempo = 2000){
    return new Promise(function(resolve){
        setTimeout(() => {
            resolve()
        }, tempo);
    })
}

function retornarValor(){
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(10)
        }, 2000);
    })
}

async function executar(){
    let valor = await retornarValor()
    await esperarPor(2000)
    console.log(`async/await ${valor}...`)
    await esperarPor(1500)
    console.log(`async/await ${valor + 1}...`)
    await esperarPor(1000)
    console.log(`async/await ${valor + 2}...`)
}

const v = executar()

executar().then(console.log)