// Functors são wrappers, objetos, que guardam valores e possuem função .map para transformar seus valores
// Array em javascript é um functor
// Observables são functors também

const nums = [1,2,3,4,5,6];
const novoNums = nums.map(el => el + 10).map(el => el*2);
console.log(nums, novoNums);

function tipoSeguro(valor){
    return {
        valor,
        invalido(){
            return this.valor === null || this.valor === undefined;
        },
        map(fn) {
            if(this.invalido()){
                return tipoSeguro(null);
            }
            const novoValor = fn(this.valor);
            return tipoSeguro(novoValor); 
        }
    }
}
const resultado = tipoSeguro('Esse é um texto').map(t => t.toUpperCase()).map(t => `${t}!!!`).map(t => t.split('').join(' '));
console.log(resultado.valor);