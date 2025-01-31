const { Observable, noop } = require('rxjs')

function entre(min,max){
    return new Observable(subscriber => {
        Array(max-min).fill().map((_, i) => {
            subscriber.next(min+i);
        })
        subscriber.complete();
    });
}

entre(4,10).subscribe(console.log, noop, console.log('fim!'))