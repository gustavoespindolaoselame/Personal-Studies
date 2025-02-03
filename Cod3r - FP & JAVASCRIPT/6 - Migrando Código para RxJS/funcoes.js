const { subscribe } = require('diagnostics_channel');
const fs = require('fs');
const simbols = ['-', '?', '-', '"', '♪', '_', '<i>', '</i>', '\r', '[', ']', '(', ')', '.']
const path = require('path')
const { Observable } = require('rxjs')

function createPipeableOperator(pipedFunction){
    return source => {
        return new Observable(subscriber => {
            source.subscribe({
                next: (valor) => pipedFunction.next(valor, subscriber),
                complete: () => pipedFunction.complete(subscriber),
                error: (err) => pipedFunction.error(err, subscriber)
            })
        })
    }
}

function lerDiretorios(caminho) {
    return new Observable(subscriber => {
        try {
            fs.readdirSync(caminho).forEach(arquivo => {
                subscriber.next(path.join(caminho, arquivo))
            })
            subscriber.complete()
        } catch (e) {
            subscriber.error(e)
        }
    })
}

function elementosTerminadosCom(padraoTextual){
    return createPipeableOperator({
        next: (valor, subscriber) => {
            if(valor.endsWith(padraoTextual)){
                subscriber.next(valor);
            }
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}

function lerArquivo() {
    return createPipeableOperator({
        next: (valor, subscriber) => {
            const conteudo = fs.readFileSync(valor, {encoding: 'utf-8'});
            subscriber.next(conteudo.toString());
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    })
}

function separarElementosPor(simbolo){
    return createPipeableOperator({
        next: (valor, subscriber) => {
            valor.split(simbolo).forEach(parte => {
                subscriber.next(parte)
            })
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}

function removerElementosVazios(){
    return createPipeableOperator({
        next: (valor, subscriber) => {
            if(valor.trim()){
            subscriber.next(valor)
            }
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}

function removerElementosSeApenasNumero(){
    return createPipeableOperator({
        next: (valor, subscriber) => {
            const num = parseInt(valor.trim());
            if(num !== num){
            subscriber.next(valor);
            }
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}

function removerSimbolos(){
    return createPipeableOperator({
        next: (valor, subscriber) => {
            const textoSemSimbolos = simbols.reduce((acc, simbolo) => {
                return acc.split(simbolo).join('');
            }, valor) 
            subscriber.next(textoSemSimbolos);
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}

function acharFrequencia(){
    return createPipeableOperator({
        next: (arrayPalavras, subscriber) => {
            let freq = {};
            arrayPalavras.forEach(palavra => {
                if (freq[palavra]) {
                    freq[palavra]++;
                } else {
                    freq[palavra] = 1;
                }
            });
            subscriber.next(Object.keys(freq).map(palavra => ({ elemento: palavra, qtde: freq[palavra] })));
        },
        complete: (subscriber) => {subscriber.complete()},
        error: e => {}
    });
}


module.exports = {
    lerDiretorios, 
    createPipeableOperator, 
    lerArquivo,
    elementosTerminadosCom,
    removerElementosVazios,
    removerElementosSeApenasNumero,
    separarElementosPor,
    removerSimbolos,
    acharFrequencia
}