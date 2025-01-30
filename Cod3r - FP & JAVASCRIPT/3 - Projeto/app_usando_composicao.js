const fns = require('./funcoes')

fns.composicao(
    fns.getValidWords,
    fns.acharFrequencia,
    fns.ordenarResultado,
    fns.arrayParaObjeto,
)(fns.lerTodosArquivos()).
    then(console.log).
    catch(console.log);
    