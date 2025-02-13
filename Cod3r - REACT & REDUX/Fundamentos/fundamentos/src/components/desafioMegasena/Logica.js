export default (tamanhoArray, numeroMin, numeroMax) => {
    if((numeroMax-numeroMin)<tamanhoArray){
        return "Itens demais"
    }
    const returnArray = []
    while(tamanhoArray>0){
        let value = `${parseInt((Math.random() * (numeroMax-numeroMin)) + numeroMin)} `
        if(!returnArray.includes(value)){
            console.log(returnArray.includes(value))
            returnArray.push(value);
            tamanhoArray--;
        }
    }
    return returnArray
}