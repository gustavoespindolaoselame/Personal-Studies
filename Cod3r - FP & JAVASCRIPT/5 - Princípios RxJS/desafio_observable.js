const { Observable, noop } = require('rxjs');
//Criar uma stream de numeros entre min e max com observable

const streamNumeros = (min, max) => {
    return new Observable(subscriber => {
        while(min<=max){
        subscriber.next(min++);
        }
        subscriber.complete();
    })
};

streamNumeros(0,10).subscribe(console.log,
    noop,
    console.log("fim!")
);