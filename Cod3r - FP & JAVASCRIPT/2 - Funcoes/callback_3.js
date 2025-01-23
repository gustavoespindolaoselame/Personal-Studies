const carrinho = [
    {
        nome: 'Caneta',
        qtde: 10,
        preco:7.99
    },
    {
        nome: 'Impressora',
        qtde: 0,
        preco:649.50
    },
    {
        nome: 'Caderno',
        qtde: 4,
        preco:27.10
    },
    {
        nome: 'Lapis',
        qtde: 3,
        preco:5.82
    },
    {
        nome: 'Tesoura',
        qtde: 1,
        preco:19.20
    }
]

const getNomes = item => item.nome;
const getPrecoFinal = item => item.qtde*item.preco;
console.log(carrinho.map(getNomes),carrinho.map(getPrecoFinal));

Array.prototype.meuMap = function(fn){
    const mapped = [];
    for(let i = 0; i < this.length; i++){
        const result = fn(this[i], i, this);
        mapped.push(result);
    }
    return mapped;
}

console.log(carrinho.meuMap(getNomes))