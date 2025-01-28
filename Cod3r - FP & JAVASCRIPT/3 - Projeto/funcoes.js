const fs = require('fs');
const path = require('path');

function lerArquivo(caminho) {
    return new Promise((resolve, reject) => {
        fs.readFile(caminho, (err, data) => {
            if (err) {
                reject(err);
            } else {
                resolve(data.toString());
            }
        });
    });
}

async function lerTodosArquivos() {
    let i = 1;
    let resultado = "";
    while (true) {
        try {
            if(i<10){
                i = "0" + i
            }
            let filePath = path.join(__dirname, 'legendas', `legendas_${i}.srt`);
            resultado = resultado + await lerArquivo(filePath);
            i++;
        } catch (e) {
            return resultado;
        }
    }
}

function pegarSoPalavras(arrayPalavras){
    return new Promise((resolve) => resolve(arrayPalavras.match(/[a-zA-Z]+/g)));
}

function acharFrequencia(arrayPalavras){
    return new Promise((resolve) => {
        let freq = {};
        arrayPalavras.forEach(palavra => {
            if (freq[palavra]) {
                freq[palavra]++;
            } else {
                freq[palavra] = 1;
            }
        });
        resolve(Object.entries(freq));
    })
}

function ordenarResultado(freqArray){
    return new Promise((resolve) => resolve(freqArray.sort((a,b)=> b[1]-a[1])))
}

function arrayParaObjeto(freqArray){
    return new Promise((resolve) => {
        let result =  freqArray.reduce((acc, [chave, valor]) =>{
            acc[chave] = valor;
            return acc;
        }, {});
        resolve(result);
    })
}

module.exports = {
    lerTodosArquivos, lerArquivo, pegarSoPalavras, acharFrequencia, ordenarResultado, arrayParaObjeto
}