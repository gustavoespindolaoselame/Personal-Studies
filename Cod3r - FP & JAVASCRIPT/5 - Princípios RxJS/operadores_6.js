const { from, Observable } = require('rxjs')

function createPipeableOperator(pipedFunction){
    return function(source){
        return new Observable(subscriber => {
            source.subscribe({
                next: (valor) => pipedFunction.next(valor, subscriber),
                complete: () => pipedFunction.complete(subscriber),
                error: (err) => pipedFunction.error(err, subscriber)
            })
        })
    }
}

const primeiro = {
    next: (valor, subscriber) => {
        subscriber.next(valor)
        subscriber.complete();},
    complete: () => console.log("fim\n"),
    error: e => console.log(e)
}

const ultimo = {ultimoValor: null,
    next: (valor) => {
        ultimoValor=valor;},
    complete: (subscriber) => {
        subscriber.next(ultimoValor);
        subscriber.complete();
        console.log("fim\n");},
    error: e => console.log(e)
}

const nenhum = {
    next: (_, subscriber) => {
        subscriber.complete(); },
    complete: () => {
        console.log("fim\n"); },
    error: e => console.log(e)
}

from([1,2,3,4,5]).
    //pipe(createPipeableOperator(primeiro)).
    //pipe(createPipeableOperator(ultimo)).
    //pipe(createPipeableOperator(nenhum)).
    subscribe(
        console.log);