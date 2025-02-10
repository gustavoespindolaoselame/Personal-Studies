import React from 'react'

export default function(props){
    const status = props.nota >= 7 ? 'Aprovado' : 'Reprovado'
    //Doesnt Work:
    // props.nome = 'banana'

    //Works:
    const nomesMaisSilva = props.nome + " Silva"
    return (
        <div>
            <h2>
                {nomesMaisSilva}
            </h2>
            <h3>
                {props.nota}
            </h3>
            <strong>
                { status } 
            </strong>
        </div>
    )
}