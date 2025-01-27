const fs = require('fs')
const path = require('path')

const lerArquivoBig = nome =>{
    return new Promise(resolve => {
        let caminho = path.join(__dirname, `${nome}.txt`)
        let file = fs.readFile(caminho, function(_, conteudo){ resolve(console.log(conteudo.toString()))})
        resolve(file)
    })
}

lerArquivoBig("dados").then(conteudo => console.log("Depois de ler"))

