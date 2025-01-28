const fs = require('fs');
const path = require('path');

function lerArquivo(caminho) {
    return new Promise((resolve, reject) => {
        fs.readFile(caminho, (err, data) => {
            if (err) {
                reject(err);
            } else {
                resolve(data.toString());
            }
        });
    });
}

async function lerTodosArquivos() {
    let i = 1; // Initialize i to 1
    let resultado = "";
    while (true) {
        try {
            if(i<10){
                i = "0" + i
            }
            let filePath = path.join(__dirname, 'legendas', `legendas_${i}.srt`);
            resultado = resultado + await lerArquivo(filePath);
            i++;
        } catch (e) {
            return resultado.match(/[a-zA-Z]+/g);
        }
    }
}


lerTodosArquivos().then(resultado => console.log(resultado));