const pessoa = {
    nome: 'Maria',
    altura: 1.76,
    cidade: 'São Paulo',
    end: {
        rua: 'Feliz!'
    }
}
console.log("Original, atribuição direta - ")
console.log(pessoa);

pessoa.nome = 'João';
pessoa.cidade = 'Fortaleza';
console.log(pessoa);

//Atribuição por referência (MUTÁVEL)
const novaPessoa = pessoa;
novaPessoa.nome = 'Joaquim';
novaPessoa.cidade = 'Porto belo';
console.log("Atribuição por referência - ")
console.log(novaPessoa);
console.log("Original - ")
console.log(pessoa);

//Atribuição sem referência (IMUTÁVEL)
const novaPessoa2 = { ...pessoa};
novaPessoa2.nome = 'Leonardo';
novaPessoa2.cidade = 'Porto';

console.log("Atribuição sem referência - ")
console.log(novaPessoa2);
console.log("Original - ")
console.log(pessoa);

//Atribuição sem referência, porém os objetos internos podem ser variados
const novaPessoa3 = { ...pessoa};
novaPessoa3.end.rua = 'Leopoldo leopoldino';

console.log("Atribuição sem referência com objeto interno - ")
console.log(novaPessoa3);

console.log("Original - ")
console.log(pessoa);