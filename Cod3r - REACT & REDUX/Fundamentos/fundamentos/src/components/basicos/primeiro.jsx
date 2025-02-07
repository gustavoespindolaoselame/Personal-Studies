import React from 'react'

export default function(){
    const msg = 'Seja bem vindo(a)!'
    return(
        <div>
            <h2>Primeiro Componente</h2>
            <p>{ msg }</p>
        </div>
        );  
}

export function Banana(){
    return 'Banana'
}