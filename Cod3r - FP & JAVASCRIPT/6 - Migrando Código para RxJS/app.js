const fns = require('./funcoes')

fns.lerTodosArquivos().
    then(fns.getValidWords).
    then(fns.acharFrequencia).
    then(fns.ordenarResultado).
    then(fns.arrayParaObjeto).
    then(console.log).
    catch(console.log);
    