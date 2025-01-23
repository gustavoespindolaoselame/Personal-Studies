numeros = [6,5,7,3,9,14,10,15,3,16,4,4,5,20,2,2,3,4,5,6,7,19,1,1,1,21,324324242,0,0,0,34,3243,9,9,9]
const maiorQue999 = (valor) => valor > 999
console.log(numeros.filter(maiorQue999));


Array.prototype.meuFilter = function(fn){
    const mapped = [];
    for(let i = 0; i < this.length; i++){
        if(fn(this[i], i, this)==true){
            mapped.push(this[i]);
        }
    }
    return mapped;
}
console.log(numeros.meuFilter(maiorQue999));


const maisalto = (acc,current) => current > acc ? current : acc;
console.log(numeros.reduce(maisalto));

Array.prototype.meuReduce = function(fn, inicial){
    let acc = inicial;
    for(let i = 0; i < this.length; i++){
        if(!acc && i === 0)
        {
            acc = this[i];
            continue
        }
        acc = fn(acc, this[i], i, this);
    }
    return acc;
}

console.log(numeros.meuReduce(maisalto, 0));