// Arrow Functions

const felizNatal = (x=10) => {
console.log("Feliz Natal!")
}

felizNatal()

const saudacao = nome => `fala ${nome}, blz?!?`
console.log(saudacao('maria'))


// Função anônima que tem numeros como um parâmetro
const somar = (...numeros) => {
    //console.log(Array.isArray(numeros))
    let total = 0;
    for(let n of numeros){
        total += n;
    }
    return total;
}


const potencia = base => exp => {return Math.pow(base, exp)}


// this
const numeros = [-333,1,2,3,500]
Array.prototype.ultimo = () =>{
    console.log(this[this.length-1])
}

Array.prototype.primeiro = function(){
    console.log(this[0])
}

console.log(somar(1,2,3))
console.log(somar(1,2,3,4,5,6))
console.log(somar(1,2))
console.log(potencia(2)(3))
numeros.ultimo()
numeros.primeiro()

