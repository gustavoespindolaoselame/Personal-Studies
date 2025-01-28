const fns = require('./funcoes')

fns.lerTodosArquivos().
    then(fns.pegarSoPalavras).
    then(fns.acharFrequencia).
    then(fns.ordenarResultado).
    then(fns.arrayParaObjeto).
    then(console.log);