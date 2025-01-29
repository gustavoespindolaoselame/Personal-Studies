//Função com imutabilidade
function ordenar(array){
    return [...array].sort();
}
//Lidando de forma mutável
const nums = [3,1,7,9,4];
console.log(nums.sort());

//Lidando de forma imutável
const nums2 = [3,1,7,9,4];
console.log(ordenar(nums2));
console.log(nums2);

//Como proteger dados
try{
    const nums3 = Object.freeze([3,1,7,9,4]);
    console.log(nums3.sort());
} catch(e){
    console.log("Err");
}