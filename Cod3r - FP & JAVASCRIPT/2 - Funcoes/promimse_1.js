const embananar = palavra => palavra + "banana"

const arrayToString = arrayEntrada => {
    let stringSaida = "";
    for(let i = 0;i<arrayEntrada.length; i++){
        stringSaida += (`${i} - ` + arrayEntrada[i] + ";\n");
    }
    return stringSaida;
}

let p = new Promise(cumprirPromessa => cumprirPromessa(["Ana","Bia","Gui"]))

p.
    then(arrayToString).
    then(embananar).
    then(letra => letra.toLowerCase()).
    then(valor => console.log(valor));

new Promise(cumprirPromessa => cumprirPromessa(["Brother","Blingas","Dambas"])).
then(arrayToString).
then(embananar).
then(letra => letra.toLowerCase()).
then(valor => console.log(valor));
