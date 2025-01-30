function composicao(...fns){
    return function(valor){
        return fns.reduce((acc,fn) => {
            return fn(acc);
        }, valor)
    }
}

function gritar(texto){
    return texto.toUpperCase();
}

function enfatizar(texto){
    return `${texto}!!!`;
}

function tornarLento(texto){
    return texto.split('').join(' ');
}

const exagerado = composicao(
    gritar, 
    enfatizar, 
    tornarLento
    )

const umPoucoMenosExagerado = composicao(
    gritar, 
    enfatizar
    )

let resultado = exagerado('para')
console.log(resultado)
resultado = exagerado('receba')
console.log(resultado)
resultado = umPoucoMenosExagerado('receba')
console.log(resultado)