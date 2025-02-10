import React from 'react'

export default function Fragmento(){
    return (
        <>
            {/* Podem ser assim, mas assim não suporta parâmetros */}
            <>
                <h2>Fragmento</h2>
                <p>Cuidado Com Esse Erro</p>
            </>
            {/* Ou podem ser assim, e assim suportam parâmetros. */}
            <React.Fragment key = "1">
                <h2>Fragmento Alternativo</h2>
                <p>Cuidado Com Esse Erro</p>
            </React.Fragment>
        </>
    )
}