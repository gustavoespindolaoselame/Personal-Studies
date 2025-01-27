// setTimeout(() => { console.log("Executando callback 1 ...")
//     setTimeout(() => { console.log("Executando callback 2 ...")
//             setTimeout(() => { console.log("Executando callback 3 ...")
//         }, 2000)
//     }, 2000)
// }, 2000)

function esperarPor(tempo = 2000){
    return new Promise(function(resolve){
        setTimeout(() => {
            console.log("executando promise...")
            resolve()
        }, tempo);
    })
}

let p = esperarPor(5).then(() => esperarPor()).then(esperarPor())