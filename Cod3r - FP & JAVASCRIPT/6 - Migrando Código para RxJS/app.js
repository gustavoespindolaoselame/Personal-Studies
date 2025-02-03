const fns = require('./funcoes')
const { toArray, map } = require('rxjs/operators')
const _ = require('lodash')
const path = require('path')
const caminho = path.join(__dirname, 'legendas')

fns.lerDiretorios(caminho).
    pipe(
        fns.elementosTerminadosCom('.srt'),
        fns.lerArquivo(),
        fns.separarElementosPor("\n"),
        fns.removerElementosVazios(),
        fns.removerElementosSeApenasNumero(),
        fns.removerSimbolos(),
        fns.separarElementosPor(' '),
        fns.removerElementosVazios(),
        toArray(),
        fns.acharFrequencia(),
        map(array => _.sortBy(array, el => -el.qtde))
    ).
    subscribe(console.log)
        