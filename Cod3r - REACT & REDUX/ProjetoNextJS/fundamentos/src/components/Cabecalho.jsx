import { useState } from "react"

export default function Cabecalho(props){
    const [banana, setBanana] = useState(0);
    return (
        <header>
        <h1>
            {props.name}
            Fundamentos de NextJS
        </h1>
        {banana}
        <button onClick={_ => setBanana(banana+1)}>+1</button>
        </header>
    )
}