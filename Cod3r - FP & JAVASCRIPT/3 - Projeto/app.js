const fns = require('./funcoes')

fns.lerTodosArquivos().
    then(fns.getValidWords).
    then(console.log).
    catch(console.log);

    // then(fns.acharFrequencia).
    // then(fns.ordenarResultado).
    // then(fns.arrayParaObjeto).
    