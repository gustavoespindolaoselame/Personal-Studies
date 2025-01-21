// 1) Passar uma função como parâmetro para outra função
function executarQualquerCoisa(fn){
    if(typeof fn == "function"){
        fn()
    }
}

function bomDia(){
    console.log("Bom Dia!");
}

const boaTarde = function(){
    console.log("Boa Tarde!");
}

executarQualquerCoisa(3)
executarQualquerCoisa(bomDia)
executarQualquerCoisa(boaTarde)

