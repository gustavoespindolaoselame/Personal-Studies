// 

// //calcular(3)(7)(fn)

// function somar(a){
//     return function(b){
//         return function(c){
//             return a + b + c;
//         }
//     }
// }

//console.log(somar(3)(4)(5));

function calcular(x){
    return function(y){
        return function(fn){
            return fn(x,y);
        }
    }
}

function somar(x, y){
    return x + y;
}

function subtrair(x,y){
 return x-y;
}

const r1 = calcular(3)(7)(somar)
console.log(r1);