const { Observable} = require('rxjs');
//Criar uma stream de numeros entre min e max com observable

const streamNumeros = (min, max) => {
    return new Observable(subscriber => {
        while(min<=max){
        subscriber.next(min++);
        }
    })
};

streamNumeros(0,10).subscribe(console.log);