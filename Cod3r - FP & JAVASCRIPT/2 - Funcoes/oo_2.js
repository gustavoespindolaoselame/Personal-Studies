class Produto {
    constructor(nome, preco, desc = 0.2){
        this._nome = nome
        this._preco = preco
        this._desc = desc
    }

    get nome(){
        return this._nome;
    }

    set nome(novoNome){
        this._nome = novoNome + " NOVO NOME";
    }

    get preco(){
        return this._preco;
    }

    set preco(novoPreco){
        if(novoPreco > 0){
            this._preco = novoPreco;
        }
    }

    precoFinal(){
        return this._preco * (1-this._desc);
    }
}

const p1 = new Produto('Caneta', 8.59)
console.log(p1.precoFinal())
console.log(p1.nome)
p1.nome = 'novoNome'
console.log(p1.nome)

p1.preco = -20
console.log(p1.precoFinal())

Produto.prototype.log = function(){
    console.log(`Nome: ${this.nome} Preço:${this.preco}`)
}

console.log(p1.log())

Object.defineProperty(Produto.prototype, 'descString', {
    get: function(){
        return `${this._desc * 100}%`
    },
    set: function(novoDesc){
        if(novoDesc>=0){
            this._desc = novoDesc;
        }
    }
})

console.log(p1.descString)

p1.descString = 0.75

console.log(p1.descString)

console.log(p1._desc)