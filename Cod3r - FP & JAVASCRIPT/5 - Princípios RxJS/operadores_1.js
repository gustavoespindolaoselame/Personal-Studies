// OS dois tipos de operação, criadores e encadeáveis.

// Exemplo de operador de criação
const { of } = require('rxjs')

// Exemplode de operador de cadeia
const { last, map } = require('rxjs/operators')

const obs = of(1,2,'ana', false, 'ultimo').
    pipe(
        last(), 
        map(v=>v[0]), 
        map(v=>v+"aaa")).
    subscribe(console.log)