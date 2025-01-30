const letras = [
    ['O',['l'],'á'],
    [' '],
    ['m',['u',['n']],'d','o'],
    ['!','!','!','!']
];

const resultado = letras.flat(Infinity).map(l => l.toUpperCase()).reduce((a,b) => a + b);
console.log(resultado);

const resultado2 = letras.flatMap(l => [l, ',']).reduce((a,b) => a + b);
console.log(resultado2);

