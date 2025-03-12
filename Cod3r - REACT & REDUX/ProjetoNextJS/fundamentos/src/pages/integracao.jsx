import Layout from "@/components/Layout";
import { useState } from "react";

export default function Integracao(){
    // http://localhost:3000/api/clientes/123

    const [codigo, setCodigo] = useState(1)
    const [cliente, setCliente] = useState({})

    async function requisicionarCliente(){
        const resp = await fetch(`http://localhost:3000/api/clientes/${codigo}`);
        const dados = await resp.json()
        setCliente(dados);
    }

    return (
        <Layout titulo = 'Integração'>
            <div>
                <input type='number' value={codigo} onChange={e => setCodigo(e.target.value)}></input>
                <button onClick={requisicionarCliente}>botão</button>
            </div>
            <ul>
                <li>ID: {cliente.id}</li>
                <li>Nome: {cliente.nome}</li>
                <li>EMail: {cliente.email}</li>
            </ul>
        </Layout>
    )
}