const { Observable } = require('rxjs');

function elementosComDelay(tempo, ...elementos){
    return Observable.create(subscriber => {
        (elementos || []).forEach((el, i) => {
            setTimeout(() => {
                subscriber.next(el);
                if(elementos.length === 1 +1){
                    subscriber.complete()
                }
            }, tempo * (i+1));
        })
    })
}

elementosComDelay(1000, 1,0.95,false,'bia',5).subscribe(console.log);