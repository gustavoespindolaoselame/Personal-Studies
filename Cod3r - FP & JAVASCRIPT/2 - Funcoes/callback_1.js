const subtrair = (w,z) => w - z

const somarNoTerminal = (x,y) => console.log(x+y)

const subtrairNoTerminal = (x,y) => console.log(x-y)

const exec = (fn, x, y) => {
    fn(x,y);
}

const fn = () => console.log('Exec...')

exec(somarNoTerminal, 56, 38)
exec(subtrairNoTerminal, 182, 27)
console.log(exec(subtrair,50,25))
setTimeout(fn, 1000)