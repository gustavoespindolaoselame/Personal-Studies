// Pega um array e faz algo para cada item

banana = [1,2,3,4]

const embananar = x => console.log(x)

banana.map(embananar)

nomes = ["gui", "bia", "anão", "ian"]
const inicial = x => x.charAt(0)
console.log(nomes.map(inicial))

const nums = [1,2,3,4,5,6]
const dobro = (n,i,a) => n * 2 + i + a.length
console.log(nums.map(dobro))