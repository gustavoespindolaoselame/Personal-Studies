const fs = require('fs');
const path = require('path');
const simbols = ['-', '?', '-', '"', '♪', '_', '<i>', '</i>', '\r', '[', ']', '(', ')', '.']

function lerArquivo(pageIndex) {
    return new Promise((resolve, reject) => {
        fs.readFile(path.join(__dirname, 'legendas', `legendas_${pageIndex}.srt`), {encoding: 'utf-8'}, (err, data) => {
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
    try{
        while (true) {
            try {
                if(i<10){
                    i = "0" + i
                }
                resultado = resultado + await lerArquivo(i);
                i++;
            } catch (e) {
                return resultado;
            }
        }
    } catch (e) {
        throw new Error("File couldn't be read");
    }
}

function getValidWords(arrayPalavras){
    return new Promise((resolve) => {
        removerSeVazio(arrayPalavras)
            .then(separarPorLinhas)
            .then(removerLinhasSeIncluir('-->'))
            .then(removerLinhasSeApenasNúmero)
            .then(removerSimbolos(simbols))
            .then(remvoverVazio)
            .then(mesclarElementos)
            .then(separarPorPalavra)
            .then(resolve);
    });
}
function removerSeVazio(array){
    return new Promise((resolve) =>resolve(array.trim()));
}
function removerLinhasSeIncluir(padraoTextual) {
    return function(array){
        return array.filter(el => !el.includes(padraoTextual));
    }
}
function removerLinhasSeApenasNúmero(array) {
    return array.filter(el => {
        const num = parseInt(el.trim());
        return num !== num;
    });
}
function removerSimbolos(simbolos){
    return function(array){
        return array.map(el => {
            let textoSemSimbolos = el;
            simbolos.forEach(simbolo => {
                textoSemSimbolos = textoSemSimbolos.split(simbolo).join('');
            })
            return textoSemSimbolos;
        })
    }
}
const mesclarElementos = array => array.join('');
const separarPorPalavra = array => array.split(' ');
const separarPorLinhas = array => array.split('\n');

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
    lerTodosArquivos, 
    getValidWords, 
    acharFrequencia, 
    ordenarResultado, 
    arrayParaObjeto
}