const pessoa = {
    nome: 'Maria',
    alutura: 1.76,
    cidade: 'São Paulo'
}
pessoa.nome = 'João';
pessoa.cidade = 'Fortaleza';
console.log(pessoa);

//Atribuição por referência (MUTÁVEL)
const novaPessoa = pessoa;
novaPessoa.nome = 'Joaquim';
novaPessoa.cidade = 'Porto belo';
console.log(novaPessoa);
console.log(pessoa);

//Atribuição sem referência (IMUTÁVEL)
const novaPessoa2 = { ...pessoa};
novaPessoa2.nome = 'Leonardo';
novaPessoa2.cidade = 'Porto';

console.log(novaPessoa2);
console.log(pessoa);