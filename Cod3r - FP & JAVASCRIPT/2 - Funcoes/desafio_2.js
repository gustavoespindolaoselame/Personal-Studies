const carrinho = [
    {
        nome: 'Caneta',
        qtde: 10,
        preco:7.99,
        fragil: true
    },
    {
        nome: 'Impressora',
        qtde: 1,
        preco:649.50,
        fragil: true
    },
    {
        nome: 'Caderno',
        qtde: 4,
        preco:27.10,
        fragil: false
    },
    {
        nome: 'Lapis',
        qtde: 3,
        preco:5.82,
        fragil: false
    },
    {
        nome: 'Tesoura',
        qtde: 1,
        preco:19.20,
        fragil: true
    }
]

const fragil = item => item.fragil==true
const qtde = item => {
    return {
        qtde: item.qtde, 
        preco: item.preco
    }
}

const mediaTotal = (acumulador, valorAtual) => {
    const novaQtde = acumulador.qtde + 1;
    const novoTotal = acumulador.total + valorAtual.preco;
    return{
        qtde: novaQtde,
        total: novoTotal,
        media:  novoTotal/novaQtde
    }
}

const mediaInicial = {qtde: 0,total: 0,media: 0}

console.log(carrinho.filter(fragil))
console.log(carrinho.map(qtde))
console.log(carrinho.reduce(mediaTotal, mediaInicial))