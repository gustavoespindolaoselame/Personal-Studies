import { useState } from "react";
import Layout from "../components/Layout";

export default function Estado(){
    const [valor, setValor] = useState(0);
    const [inc, setInc] = useState(1);
    return (
        <Layout titulo="Componente com Estado">
            <span>{valor}</span><br/>
            <button onClick={_ => setValor(parseInt(valor)+parseInt(inc))} style={{
                width: '3%'
            }}>+</button>
            <button onClick={_ => setValor(valor-inc)} style={{
                width: '3%'
            }}>-</button>
            <input type='number' value={inc} onChange={e => setInc(e.target.value)}></input>
        </Layout>
    )
}