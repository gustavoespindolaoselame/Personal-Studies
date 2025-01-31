const readLine = require('readline')

function obterResposta(pergunta){
    const rl = readLine.createInterface({
        input: process.stdin,
        output: process.stdout
    })
    return new Promise(resolve => {
        rl.question(pergunta, resp => {
            resolve(resp);
        });
    });
}

function namorada(){
    setTimeout(() => {
        console.log('N: Apagar as Luzes')
        console.log('N: Pedir silêncio')
        console.log('N: Surpresa!!!')  
    }, 2000);
}

function sindico(){
    console.log('S: Monitorando o barulho!')
}

async function porteiro(interessados){
    while(true){
        const resp = await obterResposta('O namorado chegou? (s/n/q)');
        if(resp.toLowerCase() === 's'){
        (interessados || []).forEach(obs => obs());
        } else if(resp.toLowerCase() === 'q'){
            break;
        }
    }
}

/*
Registra dois observadores, a namorada e o síndico
O subject é o porteiro
*/
porteiro([namorada,sindico]);