const { of, Observable } = require('rxjs')

const pegarUltimoSobrenome = nomeCompleto => {
    const sobrenomes = nomeCompleto.split(' ');
    return sobrenomes[sobrenomes.length-1];
}; 

function terminadoCom(palavraABater){
    return function(source){
        return new Observable(subscriber => {
            source.subscribe({
                next(v) {
                    if(pegarUltimoSobrenome(v) === palavraABater){
                        subscriber.next(v);
                    }
                },
                error(e){
                    console.log(e)
                },
                complete(){
                    subscriber.complete()
                }
            })
        })
    }
}


of('Ana Silva', 'Maria Silva', 'Pedro Rocha').
    pipe(terminadoCom('Silva')).
    subscribe(console.log)