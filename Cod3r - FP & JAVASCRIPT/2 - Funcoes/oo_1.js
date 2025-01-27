function Produto(nome, preco, desc = 0.15){
    this.nome = nome;
    this.preco = preco;
    this.desc = desc;

    let privado = "3";

    this.getNome = function(){
        return this.nome + privado
    }

    this.precoFinal = () => {
        return preco-desc
    }

    this.toString = () => {
        return {nome, preco, desc}
    }
}

const p1 = new Produto('Caneta', 8.59)
console.log(p1.getNome())
console.log(p1.precoFinal())
console.log(p1.toString())

// const p2 = new Produto('Geladeira', 2345.98)
// console.log(p2)