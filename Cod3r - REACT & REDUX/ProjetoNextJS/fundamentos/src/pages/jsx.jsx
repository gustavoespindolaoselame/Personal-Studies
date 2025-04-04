import Layout from "../components/Layout"

export default function Jsx(){
    const titulo = <h1>JSX é um conceito Central</h1>

    function subtitulo(){
        return <h2>{"muito Legal".toLocaleUpperCase}</h2>
    }

    return (
        <Layout titulo="Exemplo de CSS Modularizado">
            <div>
                {titulo}
                {subtitulo()}
                <p>
                    {JSON.stringify({nome: 'João', idade: 30})}
                </p>
            </div>
        </Layout>
    )
}