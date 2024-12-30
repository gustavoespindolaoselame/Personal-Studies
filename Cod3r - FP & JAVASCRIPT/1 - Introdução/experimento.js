function fn1(){
    console.log("fn1")
    fn2();
}

function fn2(){
    console.log("fn2")
    fn3();
}

function fn3(){
    setTimeout(() => fn4(), 3000);
    console.log("fn3")
}

function fn4(){
    console.log("timeout");
}

function main(){
    fn1();
}

// main()

setTimeout(() => {
    console.log("Exec #01");
}, 3000);

function esperarPor(tempo){
    const futuro = Date.now() + tempo;
    while(Date.now() < futuro){}
}

esperarPor(5000)
console.log("fim");
