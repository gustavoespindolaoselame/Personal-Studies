const nums = [4,8,3,2,9,1,9,3]

//#1 - Dados mutáveis e função imperativa
let total = 0;
function somar(){
    let result = 0;
    for(let i = 0;i < nums.length; i++){
        result += nums[i];
    }
    return result;
}
total = somar(nums);
console.log(total);

//#2 - Dados imutáveis, função declarativa
const somar2 = (a,b) => a + b;
const total2 = nums.reduce(somar);
console.log(total2);

//#3 - Recursividade
function somarArray(array, total = 0){
    if(array.length === 0){
        return total;
    }
    return somarArray(array.slice(1), total + array[0]);
}
console.log(somarArray(nums));
console.log(nums);
